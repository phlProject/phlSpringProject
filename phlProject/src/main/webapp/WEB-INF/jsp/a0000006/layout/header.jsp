<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->

<div id="header">
	<header id="masthead" class="site-header">
		
		<div id="logo"><a href="/a0000006/mainIndex.do"><img src="/img/logo10.png"></a></div>
		<form id="topMenu_Form">
			<input type="hidden" id="bsnsCode" 		name="bsnsCode" 	value="${sessionScope.bsnsCode}">
			<input type="hidden" id="sessionId" 	name="sessionId"  	value="${sessionScope.sessionId}">
		</form>
		<nav>
			<ul>
				<c:choose>
					<c:when test="${not empty sessionScope.loginInfo}">
						<li>
							<a href="javascript:TopMenuMove('/a0000006/member/memMyPage.do');" id="memMyPage">${sessionScope.loginInfo.MEM_NM}</a>
							
							<ul>
								<li>
									<a href="javascript:TopMenuMove('/a0000006/member/memMyPage.do');" id="memMyPage">나의 정보</a>
								</li>
								<!-- 관리자만 관리자모드 사용 가능 ( G01998 : 홈페이지 관리자 / G01999 : PHL 관리자 ) -->
								<c:if test="${loginInfo.MEM_GBN_CD eq 'G01998' || loginInfo.MEM_GBN_CD eq 'G01999'}">
									<li>
										<a href="javascript:TopMenuMove('/a0000006/manage/memList.do');" id="memList">관리자화면</a>
									</li>
								</c:if>
								<li>
									<a href="javascript:TopMenuMove('/a0000006/member/logoutAction.do');" id="logoutAction">로그아웃</a>
								</li>
							</ul>
						</li>
						
					</c:when>
					<c:otherwise>
						<li style="background-color: #fff;"><a href="javascript:TopMenuMove('/a0000006/member/memLoginForm.do');" id="memLoginForm" style="color:#000000;">로그인</a></li>
						<li><a href="javascript:TopMenuMove('/a0000006/member/memRegistForm.do');" id="memRegistForm">회원가입</a></li>
					</c:otherwise>
				</c:choose>
		
				<c:forEach var="row_dept1" items="${menuList}" varStatus="status">
					<li>
						<!-- 대메뉴 -->
						<c:if test="${row_dept1.MENU_LEVEL eq '1'}">
							 <a href="javascript:TopMenuMove('${row_dept1.MENU_LINK}')">${row_dept1.MENU_NM}</a>
						</c:if>
						
						<ul>
							<!-- 중메뉴 -->
							<c:forEach var="row_dept2" items="${menuList}" varStatus="status">
								<c:if test="${(row_dept2.MENU_LEVEL eq '2') and (row_dept1.MENU_CD eq row_dept2.UPPER_MENU_CD)}">
									<li>
										<a href="javascript:TopMenuMove('${row_dept2.MENU_LINK}')">${row_dept2.MENU_NM}</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
						
					</li>
				</c:forEach>
			</ul>
		</nav>
	</header>
</div>
