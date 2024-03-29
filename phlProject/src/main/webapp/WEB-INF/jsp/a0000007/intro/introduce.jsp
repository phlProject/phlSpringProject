<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/js/a0000007/tabMenu.js"></script>

<div id="content">
	<div class="tabmenu">
	    <ul>
	        <li class="tab1">
	        	<a href="#link"><h2>두레꿈 소개</h2></a>
	            <ul class="tabcontent">
	                <li><a href="#"></a>
	                <div class="tab-cont">
		                <div class="tab-cont3">
							<h3 class="cont1-1"></h3><br/>
							<div class="introduce"><img src="/img/a0000007/introduce.jpg"></div><br/><br/>
							<h3>첨부파일 :</h3>  
							<c:forEach items="${fileList}" var="row" varStatus="status">
								<span style="position: relative; float: left; margin: 10px;">
									<a href="javascript:fn_downloadFile('${row.BSNS_CODE}','${row.FL_SN}');" class="button1">${row.ORIGIN_FL_NM}</a>
								</span>
							</c:forEach>
							
							
						</div>
					
					</div>
	                </li>
	            </ul>
	        </li>
	        <li class="tab2">
	        	<a href="#link"><h2>학과 시간표</h2></a>
	            <ul class="tabcontent">
	                <li><a href="#"></a>
	                <div class="tab-cont3">
						<h3 class="cont1-1"></h3><br/><br/>
							<table class="tab_table" style="text-align: center;"> 
								<tr>
									<td width="6%">교시</td>
									<td width="19%">시간 / 요일</td>
									<td width="15%">월</td>
									<td width="15%">화</td>
									<td width="15%">수</td>
									<td width="15%">목</td>
									<td width="15%">금</td>
								</tr>
								<tr>
									<td>조회</td>
									<td>08:40~09:00</td>
									<td colspan="5">하루열기</td>
								</tr>
								<tr>
									<td>1</td>
									<td>09:00~09:50</td>
									<td>국어</td>
									<td>영어</td>
									<td>수학</td>
									<td>과학</td>
									<td>사회</td>
								</tr>
								<tr>
									<td>2</td>
									<td>10:00~10:50</td>
									<td>국어</td>
									<td>영어</td>
									<td>수학</td>
									<td>과학</td>
									<td>사회</td>
								</tr>
								<tr>
									<td>3</td>
									<td>11:00~11:50</td>
									<td>집단상담</td>
									<td>토론</td>
									<td>마음일기</td>
									<td>한국사</td>
									<td>프로젝트학습</td>
								</tr>
								<tr>
									<td>4</td>
									<td>12:00~12:50</td>
									<td>집단상담</td>
									<td>토론</td>
									<td>마음일기</td>
									<td>한국사</td>
									<td>프로젝트학습</td>
								</tr>
								<tr>
									<td>점심</td>
									<td>12:50~13:30</td>
									<td colspan="5">점심시간</td>
								</tr>
								<tr>
									<td>5</td>
									<td>13:30~14:20</td>
									<td>성교육</td>
									<td>생활요리</td>
									<td>창의적 체험활동</td>
									<td>사회 참여활동</td>
									<td>자기성장 프로젝트</td>
								</tr>
								<tr>
									<td>6</td>
									<td>14:30~15:20</td>
									<td>성교육</td>
									<td>생활요리</td>
									<td>창의적 체험활동</td>
									<td>사회 참여활동</td>
									<td>자기성장 프로젝트</td>
								</tr>
								<tr>
									<td>7</td>
									<td>15:30~16:20</td>
									<td>창의적 체험활동</td>
									<td>창의적 체험활동</td>
									<td></td>
									<td>사회 참여활동</td>
									<td>자기성장 프로젝트</td>
								</tr>
							</table>
					</div>
	                </li>
	            </ul>
	        </li>
	    </ul>
	</div>
</div>
<script>
	$('.tab2 a h2').click(function(){
		$('.tab1').css('height','700');
		$('.tab2 a h2').css('color','#fff').css('background','#959CAC').css('border-radius','4px 4px 0 0');
		$('.tab1 a h2').css('color','#101010').css('background','#fff').css('border-radius','4px 4px 0 0');
	});
	$('.tab1 a h2').click(function(){
		$('.tab1').css('height','1900');
		$('.tab1 a h2').css('color','#fff').css('background','#959CAC').css('border-radius','4px 4px 0 0');
		$('.tab2 a h2').css('color','#101010').css('background','#fff').css('border-radius','4px 4px 0 0');
	});
</script>