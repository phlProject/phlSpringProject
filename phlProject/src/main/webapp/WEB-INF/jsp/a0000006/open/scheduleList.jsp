<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="toYear" class="java.util.Date" />
<jsp:useBean id="toMonth" class="java.util.Date" />
<jsp:useBean id="toDay" class="java.util.Date" />

<form id="scheduleForm" name="scheduleForm" method="post">   

	<input type="hidden" name="toYear" 		id="toYear" 	value="<fmt:formatDate value="${toYear}" 	pattern="yyyy" />"/>	<!-- 현재 년도 	-->
	<input type="hidden" name="toMonth" 	id="toMonth" 	value="<fmt:formatDate value="${toMonth}" 	pattern="MM" />"/>		<!-- 현재 월 	-->
	<input type="hidden" name="toDay" 		id="toDay" 		value="<fmt:formatDate value="${toDay}" 	pattern="dd" />"/>		<!-- 현재 일 	-->
		
	<input type="hidden" name="bsnsCode"	id="bsnsCode"  	value="${sessionScope.bsnsCode}" >		<!-- 세션_업체코드	-->
	<input type="hidden" name="sessionId"	id="sessionId"  value="${sessionScope.sessionId}" >		<!-- 세션_ID 		-->
	<input type="hidden" name="scheduleSn" 	id="scheduleSn">										<!-- 일정_일련번호 	-->
	<input type="hidden" name="regId" 		id="regId">												<!-- 등록_ID		-->
			
	
	<!-- 일정 등록/상세 레이어 -->
	<div id="insertFormPop" class="insertLayer" style="display:none;">
		<div id="popName">일정 등록</div>
		<table id="insertTbl">
			<tr>
				<th>일자</th>
				<td><input type="text" name="scheduleDt" id="scheduleDt" class="text w90 datepicker"></td>
			</tr>
			
			<tr>
				<th>시간</th>
				<td>
					<select name="stHour" id="stHour" class="selectTime">
						<c:forEach begin="0" end="23" step="1" var="stHour">
							<option value='<fmt:formatNumber pattern="00" value="${stHour}"/>'><fmt:formatNumber pattern="00" value="${stHour}"/></option>
						</c:forEach>
					</select>
					~
					<select name="endHour" id="endHour" class="selectTime">
						<c:forEach begin="0" end="23" step="1" var="endHour">
							<option value='<fmt:formatNumber pattern="00" value="${endHour}"/>'><fmt:formatNumber pattern="00" value="${endHour}"/></option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<th>일정 명</th>
				<td>
					<input type="text" name="subject" id="subject" class="w200">
				</td>
			</tr>
			<tr>   
				<th>일정 내용</th>
				<td>
					<input type="text" name="content" id="contents" class="w200">
				</td>
			</tr>   
			   
		</table>
      
		<div id="buttonDiv">
			<a href="javascript:insertSchedule();">				<span>등록</span>	</a>
			<a href="javascript:closeLayer('insertFormPop');">	<span>닫기</span>	</a>
		</div>
	</div>
	
   
	<!-- 달력/날짜 표시 -->
	<div class="divWrap mt15" id="monthDiv">
		
		<!-- 날짜 표시 -->
		<div class="btn-holder">    
			<a href="javascript:void(0)"><img src="/img/left_image.png"  width="23px" 	style="padding-top:8px;" id="btnPrev"/></a>
			<span id='currentDate'></span>
			<a href="javascript:void(0)"><img src="/img/right_image.png" width="23px"	style="padding-top:8px;" id="btnNext"/></a>
		</div>
      
		<!-- 일정 등록 버튼 (삭제)
		<div class="btn">
			<a href="javascript:insertForm();"><span>일정 등록</span></a>
		</div><br> 
		-->
      
      	<!-- 달력 표시 -->
		<div id="calendar"></div>
		
	</div>

</form>


<script type="text/javascript">

 
	$(document).ready(function(){
		
		$(".datepicker").datepicker({
			showOn: "both",
			buttonImage: '<c:url value="/img/icon_calendar.gif"/>',
			dateFormat: 'yy-mm-dd',
			prevText: '이전 달',
			nextText: '다음 달',
			monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			dayNames: ['일', '월', '화', '수', '목', '금', '토'],
			dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
			dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
			showMonthAfterYear: false,
			changeYear: true,
			changeMonth: true
		});
	
		// 삭제 예정
		$(document).on( "click", ".dateSelect", function() {
			insertForm();
		});
		
	});
	

	var cList = new Array();
	var pageLoad = false;
	var calendar = new controller();
	
	// 달력
	calendar.init();
	
	function controller(target) {
		
		var that = this;  
		var m_oMonth ;
		
		var holidayYear = '';
		var holidayMon = '';
	   
		if(holidayYear == '')	m_oMonth = new Date();
		else					m_oMonth = new Date(holidayYear, holidayMon);
		
		// 현재 일자 계산
		var toYear  = String(m_oMonth.getFullYear());
	   	
		var toMonth = String(m_oMonth.getMonth() + 1);
	   	if(toMonth.length == 1) toMonth = "0" + toMonth;
	   	
		var toDate 	= String(m_oMonth.getDate());
		if(toDate.length == 1) toDate = "0" + toDate;
		
		
		m_oMonth.setDate(1);
	
		/* calendar 초기화 */
		this.init = function() {
			that.renderCalendar();
			that.initEvent();
		};
	
		/* 달력 UI 생성 */
		this.renderCalendar = function() {
			var arrTable = [];
			arrTable.push('<table><colgroup>');
			for(var i=0; i<7; i++) {
				arrTable.push('<col width="150">');
			}         
			arrTable.push('</colgroup><thead><tr>');
	   
			var arrWeek = "일요일/월요일/화요일/수요일/목요일/금요일/토요일".split("/");
			
			for(var i=0, len=arrWeek.length; i<len; i++) {
				var sClass = '';
				sClass += i % 7 == 0 ? 'sun' : '';
				sClass += i % 7 == 6 ? 'sat' : '';
				arrTable.push('<td class="'+sClass+'">' + arrWeek[i] + '</td>');
			}
	      
			arrTable.push('</tr></thead>');
			arrTable.push('<tbody>');
	   
			var oStartDt = new Date(m_oMonth.getTime());
			// 1일에서 1일의 요일을 빼면 그 주 첫번째 날이 나온다.
			oStartDt.setDate(oStartDt.getDate() - oStartDt.getDay());

			
			// 달력 For Start
			for(var i=0; i<100; i++) {

				// 달력 출력 일자 계산
				var osYear  = String(oStartDt.getFullYear());
			   	
				var osMonth = String(oStartDt.getMonth() + 1);
			   	if(osMonth.length == 1) osMonth = "0" + osMonth;
			   	
				var osDate 	= String(oStartDt.getDate());
				if(osDate.length == 1) osDate = "0" + osDate;
				
				
				if(i % 7 == 0) arrTable.push('<tr>');
	   
				var sClass = 'date-cell ';
				
				// 해당 월 일 때 : this-month , 해당 월 아닐 때 : not-this-month
				sClass += m_oMonth.getMonth() != oStartDt.getMonth() ? 'not-this-month ' : 'this-month ';
				
				// 일요일 일 때 sun
				sClass += i % 7 == 0 ? 'sun ' : '';
				
				// 토요일 일 때 sat
				sClass += i % 7 == 6 ? 'sat ' : '';
				
				// 오늘 일자 일 때 today
				sClass += osYear + osMonth + osDate == toYear + toMonth + toDate ? 'today ' : '';
				
				var sId = m_oMonth.getMonth() != oStartDt.getMonth() ? 'not' : '';
				
				// 달력에 휴일 표시
				var arrScheduleSn 	= [];      // 시퀀스 	: scheduleSn
				var arrSubject 		= [];      // 제목    	: subject
				var arrScheduleDt 	= [];      // 날짜    	: scheduleDt
				var arrStHour 		= [];      // 시작시간	: stHour
				var arrEndHour 		= [];      // 종료시간	: EndHour 
				
				if(pageLoad == false){
	            
					<c:forEach var="item" items="${scheduleList}" varStatus="status">
						arrScheduleSn.push("${item.SCHEDULE_SN}");
						arrSubject.push("${item.SUBJECT}");
						arrScheduleDt.push('${fn:substring(item.SCHEDULE_DT,8,10) }');
						arrStHour.push('<fmt:formatNumber value="${item.ST_HOUR}" pattern="00"/>');
						arrEndHour.push('<fmt:formatNumber value="${item.END_HOUR}" pattern="00"/>');
					</c:forEach>
	             
				}else{
					
					$.each(cList, function(idx, item){
	               
						// 수정
						arrScheduleSn.push(item[0]);
						arrSubject.push(item[1]);
						arrScheduleDt.push(item[2]);
						arrStHour.push(item[3]);
						arrEndHour.push(item[4]);
	                 
					});
				}
	         
				var subject = "";
				var scheduleSn = "";
				var workClass = "";
				
				
				var spanTag = '';
				
				for(var k=0; k < arrScheduleDt.length; k++) {
					if(arrScheduleDt[k] == oStartDt.getDate()){
						subject = arrSubject[k];
						scheduleSn = arrScheduleSn[k];
						workClass = "workday";
						spanTag += '<span class="holiTxt" onclick="javascript:popWorkDetail(' + scheduleSn + ');"> - '+ subject + '<br></span>';
	               
					}
				}
				
	          
				// 일 '0' 추가
				var day0 = String(oStartDt.getDate());
				if(day0.length == 1){
					day0 = "0"+day0;
				}
				
				arrTable.push('<td class="' + sClass + workClass + '">' 
						    + '<span class="schudulDate" onclick="schduleLayer('+day0+')">'+ day0 +'</span>'
						    + '<br/>' + spanTag + '</td>');
				
				oStartDt.setDate(oStartDt.getDate() + 1);
				
				if(i % 7 == 6) {
					arrTable.push('</tr>');
					if(m_oMonth.getMonth() != oStartDt.getMonth()) {
						break;
					}
				}
			} // 달력 For End
			
	   
			arrTable.push('</tbody></table>');
	
			$('#calendar').html(arrTable.join(""));
			$(".not-this-month").text("");
			that.changeMonth();
			pageLoad = true;
	      
		};
		
	
		/* Next, Prev 버튼 이벤트 */
		this.initEvent = function() {
			$("#btnPrev").on( "click", that.onPrevCalendar );
			$("#btnNext").on( "click", that.onNextCalendar );
			
			// 달력 중에 날짜가 없는 td 는 클릭이벤트 안 먹도록 "date-cell" class 를 삭제해줌.
			$(".not-this-month").each(function(){
				$(this).removeClass("date-cell");
			});
		};
	
		
		/* 이전 달력 */
		this.onPrevCalendar = function() {
	      
			// 이전 달력의 연도와 월을 구한다.
			var year = m_oMonth.getFullYear();
			var month0 = String((m_oMonth.getMonth()+1) -1);
	       
			if(month0 == "0"){
				month0 = "12";
				year = year-1;
			}
			$("#toMonth").val(month0);
			$("#toYear").val(year);
			
			
			if(month0.length == 1){
				month0 = "0"+month0;
			}
	       
	       
			$.post("/a0000006/open/ajaxScheduleList.do", $("#scheduleForm").serialize(),function(data){
				var j = 0;
				cList = new Array();
				$.each(data.scheduleList, function(idx, item){
					cList[j] = new Array(item.SCHEDULE_SN, item.SUBJECT, item.SCHEDULE_DT.substr(8,2), item.ST_HOUR, item.END_HOUR);
					j++;
				});
				m_oMonth.setMonth(m_oMonth.getMonth() - 1);
				that.renderCalendar();
	         
				// 달력 중에 날짜가 없는 td 는 클릭이벤트 안 먹도록 "date-cell" class 를 삭제해줌.
				$(".not-this-month").each(function(){
					$(this).removeClass("date-cell");
				});
			});
	       
		};
	
		
		/* 다음 달력 */
		this.onNextCalendar = function() {
			var year = m_oMonth.getFullYear();
			var month0 = String((m_oMonth.getMonth()+1) +1);
	       
			$("#toMonth").val(month0);
			if(month0.length == 1){
				month0 = "0"+month0;
			}
	
			if(month0 == "13"){
				month0 = "01";
				$("#toMonth").val(1);
				year = year+1;
			}
			$("#toYear").val(year);
			
			
			$.post("/a0000006/open/ajaxScheduleList.do", $("#scheduleForm").serialize(),function(data){
				var j = 0;
				cList = new Array();
				$.each(data.scheduleList, function(idx, item){
					cList[j] = new Array(item.SCHEDULE_SN, item.SUBJECT, item.SCHEDULE_DT.substr(8,2), item.ST_HOUR, item.END_HOUR);
					j++;
				});
				m_oMonth.setMonth(m_oMonth.getMonth() + 1);
				that.renderCalendar();
	         
				// 달력 중에 날짜가 없는 td 는 클릭이벤트 안 먹도록 "date-cell" class 를 삭제해줌.
				$(".not-this-month").each(function(){
					$(this).removeClass("date-cell");
				});
				
			});
	      
		};
	
		
		/* 달력 이동되면 상단에 현재 년 월 다시 표시 */
		this.changeMonth = function() {
			$('#currentDate').text(that.getYearMonth(m_oMonth).substr(0,9));
		};
		
		
		/* 날짜 객체를 년 월 문자 형식으로 변환 */
		this.getYearMonth = function(oDate) {
			var year  = String(oDate.getFullYear());
			var month = String(oDate.getMonth() + 1);
			if(month.length == 1) month = "0" + month;
			return year + '. ' + month;
		};
	
	}

	
	// 등록
	function insertSchedule(){
		if(validation() && confirm("등록하시겠습니까?")){
			var url = "/a0000006/open/insertSchedule.do";
			$.post(url,$("#scheduleForm").serialize(),function(data){
				if(data.result == "0" ){
					alert("등록되었습니다.");
					$( "#scheduleForm").attr({action:'/a0000006/open/scheduleList.do' ,method:'post'}).submit();
				} else{
					alert("등록에 실패했습니다.");
					return;
				}
			});
		}
	}

	
	// 수정
	function updateSchedule(){
		if(validation() && confirm("수정하시겠습니까?")){
			var url = "/a0000006/open/updateSchedule.do";
			$.post(url,$("#scheduleForm").serialize(),function(data){
				if(data.result == "0" ){
					alert("수정되었습니다.");
					$( "#scheduleForm").attr({action:'/a0000006/open/scheduleList.do' ,method:'post'}).submit();
				} else{
					alert("등록에 실패했습니다.");
					return;
				}
			});
		}
	}
	
	
	// 삭제
	function deleteSchedule(){
		if(confirm("삭제하시겠습니까?")){
			var url = "/a0000006/open/deleteSchedule.do";
			$.post(url,$("#scheduleForm").serialize(),function(data){
				if(data.result == "0" ){
					alert("삭제되었습니다.");
					$( "#scheduleForm").attr({action:'/a0000006/open/scheduleList.do' ,method:'post'}).submit();
				} else{
					alert("등록에 실패했습니다.");
					return;
				}
			});
		}
	}
	
	
	// 상세
	function popWorkDetail(scheduleSn){
		$("#scheduleSn").val(scheduleSn);
		var url = "/a0000006/open/viewSchedule.do";
		$.post(url,$("#scheduleForm").serialize(),function(data){
			
			var result = data.result;

			$("#scheduleDt").val(result.SCHEDULE_DT);
			$("#stHour").val(result.ST_HOUR);
			$("#endHour").val(result.END_HOUR);
			$("#subject").val(result.SUBJECT);
			$("#contents").val(result.CONTENT);
			$("#regId").val(result.REG_ID);
			
			// 현재 이용자가 글 작성자라면 수정버튼 생성
			var sessionId = $("#sessionId").val();
			var html = '';
			var mgLeft = 135;
			if(result.REG_ID == sessionId){
				html = '<a href="javascript:updateSchedule();"><span>수정</span></a>'
					 + '<a href="javascript:deleteSchedule();"><span>삭제</span></a>'
					 + '<a href="javascript:closeLayer(\'insertFormPop\');"><span>닫기</span></a>';
				mgLeft = 80;
			}else{
				html = '<a href="javascript:closeLayer(\'insertFormPop\');"><span>닫기</span></a>';
				mgLeft = 170;
			}
			$("#buttonDiv").html(html);
			$("#buttonDiv").css("margin-left", mgLeft);
			
			$("#insertFormPop").css("display", "block");
			
		});
	}
	
	
	// 유효성 체크
	function validation(){
	
		var userId = $("#sessionId").val();
		if(userId == ''){
			alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.");
			$( "#scheduleForm").attr({action:'/a0000006/member/memLoginForm.do' ,method:'post'}).submit();
			return false;
		}
		
		var scheduleDt = $("#scheduleDt").val();
		if(scheduleDt == null || scheduleDt == ''){
			alert('일자를 다시 입력해주세요.');
			$("#scheduleDt").focus();
			return false;
		}
		
		var stHour = $("#stHour").val();
		var endHour = $("#endHour").val();
		if(stHour >= endHour){
			alert('종료시간을 다시 입력해주세요.');
			$("#endHour").focus();
			return false;
		}
		
		var subject = $("#subject").val();
		if(subject == null || subject == ''){
			alert('제목을 다시 입력해주세요.');
			$("#subject").focus();
			return false;
		}
		var content = $("#contents").val();
		if(content == null || content == ''){
			alert('내용을 다시 입력해주세요.');
			$("#contents").focus();
			return false;
		}
		
		return true;
	}
	
	
	function insertForm(day){
		
		$("#insertFormPop").css("display", "block");
		var	html = '<a href="javascript:insertSchedule();"><span>등록</span></a>' +
		   		   '<a href="javascript:closeLayer(\'insertFormPop\');"><span>닫기</span></a>';
		$("#buttonDiv").html(html);
		$("#buttonDiv").css("margin-left", 135);
		
		if(String(day).length == 1) day = "0"+String(day);
		
		$("#toDay").val(day);
		
		$("#scheduleDt").val($("#toYear").val() + "-" + $("#toMonth").val() + "-" + $("#toDay").val());
		$("#stHour").val("09");
		$("#endHour").val("09");
		
		
		$("#subject").val("");
		$("#contents").val("");
		
		
		centerLocation("insertFormPop");
	}
	
	
	// 레이어 호출
	function schduleLayer(day){
		insertForm(day);
	}
	
	
	// 레이어 위치
	function centerLocation(obj){
	    
		var objName = "#" + obj;
		var content = $("#left_content").offset();
		var contentWidth = $("#left_content").width()/2;
		var objWidth = $(objName).width()/2;
		
		var tx = content.left + contentWidth - objWidth;
		var ty = (($(window).height() - $(objName).outerHeight()) / 2) + $(window).scrollTop();
	           
		$(objName).css({
			left : tx + "px",
			top : ty + "px"
		});
	}
	
	
	// 레이어 닫기
	function closeLayer(objId){
		$("#" + objId).css("display", "none");
	   
	}

</script>