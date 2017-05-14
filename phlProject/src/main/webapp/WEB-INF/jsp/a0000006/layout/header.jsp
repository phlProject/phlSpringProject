 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교육나눔 꿈두레</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div id="header">
	<header id="masthead" class="site-header">
		
		<div id="logo"><a href="/a0000006/mainIndex.do"><img src="/img/logo10.png"></a></div>
		<form id="topMenu_Form">
			<input type="hidden" value="${sessionScope.bsns_code}" id="bsns_code" name="bsns_code" >
			<input type="hidden" value="${sessionScope.session_id}" id="session_id" name="session_id" >
		</form>
		<nav>
			<ul>
				<!-- 로그인 관련 추후 DB메뉴화 예정 -->
				<c:choose>
					<c:when test="${not empty sessionScope.loginInfo}">
						<li><a href="javascript:TopMenuMove('/a0000006/mem/memMyPage.do');" id="memMyPage">${sessionScope.loginInfo.MEM_NM}</a></li>
						<li><a href="javascript:TopMenuMove('/a0000006/mem/logoutAction.do');" id="logoutAction">로그아웃</a></li>
						
						<!-- 관리자만 관리자모드 사용 가능 ( G01998 : 홈페이지 관리자 / G01999 : PHL 관리자 ) -->
						<c:if test="${loginInfo.MEM_GRADE eq 'G01998' || loginInfo.MEM_GRADE eq 'G01999'}">
							<li><a href="javascript:TopMenuMove('/a0000006/mng/memList.do');" id="memList">관리자</a></li>
						</c:if>
					</c:when>
					<c:otherwise>
						<li><a href="javascript:TopMenuMove('/a0000006/mem/memLoginForm.do');" id="memLoginForm">로그인</a></li>
						<li><a href="javascript:TopMenuMove('/a0000006/mem/memRegistForm.do');" id="memRegistForm">회원가입</a></li>
					</c:otherwise>
				</c:choose>
		
				<c:forEach var="row_dept1" items="${menuList}" varStatus="status">
					<li>
						<!-- 대메뉴 -->
						<c:if test="${row_dept1.MENU_LEVEL eq '1'}">
							 <a href="javascript:TopMenuMove('${row_dept2.MENU_LINK}')">${row_dept1.MENU_NM}</a>
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
				
				
				<!-- <li><a href="/sample/go.do">활동</a>
					<ul>
						<li><a href="#">헝겊원숭이 연대</a></li>
						<li><a href="#">지역교육네트워크</a></li>
						<li><a href="#">교사학교</a></li>
						<li><a href="#">청년학교</a></li>
						<li><a href="#">청소년학교</a></li>
						<li><a href="#">오시는 길</a></li>
					</ul>
				</li>
				<li><a href="#">소개</a>
					<ul>
						<li><a href="#">교육나눔 꿈두레 소개</a></li>
						<li><a href="#">운영주체</a></li>
						<li><a href="#">기관탐방/대관 신청</a></li>
						<li><a href="#">주요사업 담당 연락처</a></li>
						<li><a href="#">오시는 길</a></li>
					</ul>		
				</li>
				<li><a href="javascript:TopMenuMove('/a0000006/apply/applyList.do');">신청 및 문의</a>
					<ul>
						<li><a href="javascript:TopMenuMove('/a0000006/apply/applyList.do');">장소대관</a></li>
						<li><a href="#">기관탐방</a></li>
						<li><a href="#">문의</a></li>
					</ul>
				</li>
				<li><a href="javascript:TopMenuMove('/a0000006/board/bookList.do');">자료</a>
					<ul>
						<li><a href="javascript:TopMenuMove('/a0000006/board/bookList.do');">책소개</a></li>
						<li><a href="#">간행물</a></li>
						<li><a href="#">기타자료</a></li>
					</ul>
				</li>
				<li><a href="#">후원</a>
					<ul>
						<li><a href="#">햇빛</a></li>
						<li><a href="#">바람</a></li>
						<li><a href="#">물</a></li>
					</ul>
				</li> -->
			</ul>
		</nav>
	</header><!-- #masthead -->
</div>
</body>
</html>