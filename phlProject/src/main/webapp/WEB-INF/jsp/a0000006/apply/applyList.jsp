<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%> --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<jsp:useBean id="toYear" class="java.util.Date" />
<jsp:useBean id="toMonth" class="java.util.Date" />
<jsp:useBean id="toDay" class="java.util.Date" />

<form id="applyForm" name="applyForm" method="post">   


<input type="hidden" name="toYear" id="toYear" value="<fmt:formatDate value="${toYear}" pattern="yyyy" />"/>
<input type="hidden" name="toMonth" id="toMonth" value="<fmt:formatDate value="${toMonth}" pattern="MM" />"/>
<input type="hidden" name="toDay" id="toDay" value="<fmt:formatDate value="${toDay}" pattern="dd" />"/>
<input type="hidden" name="bsns_code" value="${bsns_code}" id="bsns_code">
<input type="hidden" name="session_id" value="${session_id}" id="session_id">
<input type="hidden" name="scheduleSn" id="scheduleSn">
<input type="hidden" name="regId" id="regId">

<!-- <div id="content"> -->

   <div id="insertFormPop" class="insertLayer" style="display:none;">
      <a href="javascript:closeLayer('insertFormPop');"><span>닫기X</span></a>
      <table id="insertTbl">
		<colgroup>
			<col width="200"></col>
			<col width="300"></col>
		</colgroup>
         <tr>
            <th>스케줄 구분</th>
            <td>
               <!-- 프로그램 신청 소공연장 강연회 세미나실 밴드연습실 댄스연습실 -->
               <select name="scheduleCd">
                  <option value="P01001">프로그램 신청</option>
                  <option value="">장소대관</option>
                  <option value=""></option>
               </select>
            </td>
         </tr>
         <tr>
            <th>일자</th>
            <td>
               <input type="text" name="scheduleDt" id="scheduleDt" class="text w90 datepicker">
            </td>
         </tr>
         <tr>
            <th>시작시간</th>
            <td>
               <select name="stHour" id="stHour">
                  <c:forEach begin="0" end="23" step="1" var="stHour">
                     <option value='<fmt:formatNumber pattern="00" value="${stHour}"/>'><fmt:formatNumber pattern="00" value="${stHour}"/></option>
                  </c:forEach>
               </select>
            </td>
            
         </tr>
         <tr>
            <th>끝시간</th>
            <td>
               <select name="endHour" id="endHour">
                  <c:forEach begin="0" end="23" step="1" var="endHour">
                     <option value='<fmt:formatNumber pattern="00" value="${endHour}"/>'><fmt:formatNumber pattern="00" value="${endHour}"/></option>
                  </c:forEach>
               </select>
            </td>
            
         </tr>
         <tr>
            <th>제목</th>
            <td>
               <input type="text" name="subject" id="subject">
            </td>
            
         </tr>
         <tr>   
            <th>내용</th>
            <td>
               <input type="text" name="content" id="content">
            </td>
         </tr>      
      </table>
      
      <div id="buttonDiv">
      	<a href="javascript:insertApply();"><span>등록</span></a>
      </div>
      
   </div>
   
   <!-- 월간 일정 -->
   <div class="divWrap mt15" id="monthDiv">
      <div class='btn-holder'>
         <a href="javascript:void(0)"><img src="/img/btn_calendarPrev.png" alt="" id="btnPrev"/></a>
         <span id='currentDate'></span>
         <a href="javascript:void(0)"><img src="/img/btn_calendarNext.png" alt="" id="btnNext"/></a>
      </div>
      
      <div style="float:right;">
         <a href="javascript:insertForm();"><span>신규 신청</span></a>
      </div><br>
      <!-- 달력 -->
      <div id="calendar"></div>
   </div>

   <!-- 주간 일정 -->
   <div class="divWrap mt15" id="weekDiv" style="display: none">
      <div id="mondayDate"></div>
      <table id="weekTable"></table>
   </div>

   <!-- 일일 일정 -->
   <div class="divWrap mt15" id="dailyDiv" style="display: none">
      <div id="dailyDateDiv"></div>
      <table id="dailyTable"></table>
   </div>

<!-- </div> -->
</form>

<script type="text/javascript">
 
function insertForm(){
   $("#insertFormPop").css("display", "block");
   //centerLocation("insertFormPop");
}
 
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

   
   $(".date-cell").each(function(){
      $(this).click(function(){
         var thisDate = $(this).text();
         insertForm();
      });
   });
  
});

function insertApply(){
   
	if(validation() && confirm("등록하시겠습니까?")){
      
		var url = "/a0000006/apply/insertApply.do";
      
		$.post(url,$("#applyForm").serialize(),function(data){
			if(data.result == "0" ){
				alert("등록되었습니다.");
				$( "#applyForm").attr({action:'/a0000006/apply/applyList.do' ,method:'post'}).submit();
			} else{
				alert("등록에 실패했습니다.");
				return;
			}
		});
	}
   
}

function updateApply(){
	if(validation() && confirm("수정하시겠습니까?")){
		var url = "/a0000006/apply/updateApply.do";
	      
		$.post(url,$("#applyForm").serialize(),function(data){
			if(data.result == "0" ){
				alert("수정되었습니다.");
				$( "#applyForm").attr({action:'/a0000006/apply/applyList.do' ,method:'post'}).submit();
			} else{
				alert("등록에 실패했습니다.");
				return;
			}
		});
	}
}

function deleteApply(){
	if(confirm("삭제하시겠습니까?")){
		var url = "/a0000006/apply/deleteApply.do";
	      
		$.post(url,$("#applyForm").serialize(),function(data){
			if(data.result == "0" ){
				alert("삭제되었습니다.");
				$( "#applyForm").attr({action:'/a0000006/apply/applyList.do' ,method:'post'}).submit();
			} else{
				alert("등록에 실패했습니다.");
				return;
			}
		});
	}
}


function validation(){

	var userId = $("#session_id").val();
	if(userId == ''){
		alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.");
		$( "#applyForm").attr({action:'/a0000006/mem/memLoginForm.do' ,method:'post'}).submit();
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
	if(stHour > endHour){
		alert('끝시간을 다시 입력해주세요.');
		$("#endHour").focus();
		return false;
	}
	
	var subject = $("#subject").val();
	if(subject == null || subject == ''){
		alert('제목을 다시 입력해주세요.');
		$("#subject").focus();
		return false;
	}
	var content = $("#content").val();
	if(content == null || content == ''){
		alert('내용을 다시 입력해주세요.');
		$("#content").focus();
		return false;
	}
	
	return true;
}


function closeLayer(objId){
   $("#" + objId).css("display", "none");
   
}

function centerLocation(obj){
    
	var objName = "#" + obj;
    var content = $("#container").offset();
    var contentWidth = $("#container").width()/2;
    var objWidth = $(objName).width()/2;
   
   
    var tx = content.left + contentWidth - objWidth;
    var ty = (($(window).height() - $(objName).outerHeight()) / 2) + $(window).scrollTop();
           //( ( $(window).height() - ($(objName).height()/2) ) ) + $(window).scrollTop();/* + ((content.top) /2);*/
   $(objName).css({
          left : tx + "px",
          top : ty + "px"
   });
}



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
   
   if(holidayYear == ''){
      m_oMonth = new Date();
   }else{
      m_oMonth = new Date(holidayYear, holidayMon);
   }
   
   var today = m_oMonth.getDate();
   m_oMonth.setDate(1);

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
   
      var arrWeek = "SUN/MON/TUE/WED/THU/FRI/SAT".split("/");

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

      for(var i=0; i<100; i++) {
         if(i % 7 == 0) {
            arrTable.push('<tr>');
         }
   
         var sClass = 'date-cell ';
         // 이번달 일때 this-month 클래스, 이번달이 아닐 때 not-this-month 클래스 추가
         sClass += m_oMonth.getMonth() != oStartDt.getMonth() ? 'not-this-month ' : 'this-month ';
   
         // 오늘 날짜일때 today 클래스 추가
         sClass += oStartDt.getDate() == today ? 'today ' : '';
   
         // 일요일일때 sun 클래스 추가
         sClass += i % 7 == 0 ? 'sun ' : '';
   
         // 토요일일때 sat 클래스 추가
         sClass += i % 7 == 6 ? 'sat ' : '';
   
         var sId = m_oMonth.getMonth() != oStartDt.getMonth() ? 'not' : '';
         
         // 달력에 휴일 표시
         var arrScheduleSn = [];      // 시퀀스 : scheduleSn
         var arrSubject = [];      // 제목    : subject
         var arrScheduleDt = [];      // 날짜    : scheduleDt
         var arrStHour = [];         // 시작시간   : stHour
         var arrEndHour = [];      // 끝시간    : EndHour 
         

         
         if(pageLoad == false){
            
            <c:forEach var="item" items="${applyList}" varStatus="status">
               arrScheduleSn.push("${item.SCHEDULE_SN}");
               arrSubject.push("${item.SUBJECT}");
               arrScheduleDt.push('${fn:substring(item.SCHEDULE_DT,8,10) }');
                 arrStHour.push('<fmt:formatNumber value="${item.ST_HOUR}" pattern="00"/>');
                 arrEndHour.push('<fmt:formatNumber value="${item.END_HOUR}" pattern="00"/>');
             </c:forEach>
             
         }else{
            $.each(cList, function(idx, item){
               
               // 수정하기
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
               
               console.log( k + "===>>>" + arrScheduleDt[k]);
               subject = arrSubject[k];
               scheduleSn = arrScheduleSn[k];
               workClass = "workday";
               
               spanTag += '<span class="holiTxt" onclick="javascript:popWorkDetail(' + scheduleSn + ');">['+ (k+1) + '] '+ subject + '<br></span>';
               
            }
          }
          // 월과 요일에 0 붙여주기
          var month0 = String((m_oMonth.getMonth()+1));
          if(month0.length == 1){
             month0 = "0"+month0;
          }
          
          var day0 = String(oStartDt.getDate());
          if(day0.length == 1){
             day0 = "0"+day0;
          }
         arrTable.push('<td id="'+sId+oStartDt.getFullYear()+"."+month0+"."+day0+'" class="'+sClass+workClass+'">'+ oStartDt.getDate() +'<br/>' + spanTag + '</td>');
         
         oStartDt.setDate(oStartDt.getDate() + 1);
   
         if(i % 7 == 6) {
            arrTable.push('</tr>');
            if(m_oMonth.getMonth() != oStartDt.getMonth()) {
               break;
            }
         }
      }//for문
   
      arrTable.push('</tbody></table>');

      $('#calendar').html(arrTable.join(""));
      $(".not-this-month").text("");
      that.changeMonth();
      pageLoad = true;
      
   };

   /* Next, Prev 버튼 이벤트 */
   this.initEvent = function() {
      $('#btnPrev').click(that.onPrevCalendar);
      $('#btnNext').click(that.onNextCalendar);
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
       
       
       $.post("/a0000006/apply/scheduleList.do", $("#applyForm").serialize(),function(data){
         var j = 0;
         cList = new Array();
         $.each(data.applyList, function(idx, item){
            cList[j] = new Array(item.SCHEDULE_SN, item.SUBJECT, item.SCHEDULE_DT.substr(8,2), item.ST_HOUR, item.END_HOUR);
            //cList[j] = new Array(item.workDt.substr(8,2),item.workSubject,'Y', item.farmWorkId,item.workHour);
            j++;
         });
         m_oMonth.setMonth(m_oMonth.getMonth() - 1);
         that.renderCalendar();
      });
       
      /* $.post("/diary/work/selectWorkList.do", $("#sectionForm").serialize(),function(data){
         var j = 0;
         cList = new Array();
         $.each(data, function(idx, item){
            cList[j] = new Array(item.workDt.substr(8,2),item.workSubject,'Y', item.farmWorkId,item.workHour);
            j++;
         });
         m_oMonth.setMonth(m_oMonth.getMonth() - 1);
         that.renderCalendar();
      }); */
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
      
      
      $.post("/a0000006/apply/scheduleList.do", $("#applyForm").serialize(),function(data){
         var j = 0;
         cList = new Array();
         $.each(data.applyList, function(idx, item){
            cList[j] = new Array(item.SCHEDULE_SN, item.SUBJECT, item.SCHEDULE_DT.substr(8,2), item.ST_HOUR, item.END_HOUR);
            j++;
         });
         m_oMonth.setMonth(m_oMonth.getMonth() + 1);
         that.renderCalendar();
      });
      
       /* $.post("/diary/work/selectWorkList.do", $("#sectionForm").serialize(),function(data){
         var j = 0;
         cList = new Array();
         $.each(data, function(idx, item){
            cList[j] = new Array(item.workDt.substr(8,2),item.workSubject,'Y', item.farmWorkId,item.workHour);
            j++;
         });
         m_oMonth.setMonth(m_oMonth.getMonth() + 1);
         that.renderCalendar();
      }); */
   };

   /* 달력 이동되면 상단에 현재 년 월 다시 표시 */
   this.changeMonth = function() {
      $('#currentDate').text(that.getYearMonth(m_oMonth).substr(0,9));
   };

   /* 날짜 객체를 년 월 문자 형식으로 변환 */
   this.getYearMonth = function(oDate) {
      return oDate.getFullYear() + '. ' + (oDate.getMonth() + 1);
   };
   
}

function popWorkDetail(scheduleSn){
	
	$("#scheduleSn").val(scheduleSn);
   
	var url = "/a0000006/apply/viewApply.do";
	$.post(url,$("#applyForm").serialize(),function(data){
		
		var result = data.result;
		
		$("#scheduleCd").val(result.SCHEDULE_CD);
		$("#scheduleDt").val(result.SCHEDULE_DT);
		$("#stHour").val(result.ST_HOUR);
		$("#endHour").val(result.END_HOUR);
		$("#subject").val(result.SUBJECT);
		$("#content").val(result.CONTENT);
		$("#regId").val(result.REG_ID);
		
		// 현재 이용자가 글 작성자라면 수정버튼 생성
		var session_id = $("#session_id").val();
		var html = '';
		if(result.REG_ID == session_id){
			html = '<a href="javascript:updateApply();"><span>수정</span></a>'
				 + '<a href="javascript:deleteApply();"><span>삭제</span></a>';
		}
		$("#buttonDiv").html(html);
		
		
	});
   
   
}


/* $(function(){
   
   var dates = $('#workDt').datepicker({
      //maxDate:'+30d',
        onSelect: function( selectedDate ) {
         var option = this.id == "workDt" ? "minDate" : "maxDate", instance = $( this ).data( "datepicker" ), date = $.datepicker.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat, selectedDate, instance.settings );
          dates.not( this ).datepicker( "option", option, date );
        }
   });
   
}); */


</script>