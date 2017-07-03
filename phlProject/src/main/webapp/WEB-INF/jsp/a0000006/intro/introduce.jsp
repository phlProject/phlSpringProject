<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
<title>교육나눔 꿈두레 - 소개</title>
</head>
<body>
	<div id="content">
	<div class="tabmenu">
	    <ul>
	        <li class="tab1">
	        	<a href="#link"><img src="/img/tab-1-off.png" alt="메뉴01" /></a>
	            <ul class="tabcontent">
	                <li><a href="#"></a>
	                <div class="tab-cont">
		                <div class="tab-cont1">
							<h3 class="cont1">교육나눔 꿈두레 ‘하는 일’</h3><br/>
							교육나눔 꿈두레는 아동과 청소년과 함께 하는 모든 일의 실천적 고민과 연대 활동에 참여하는 사람들의 지적∙정신적 성장에 기여하며 교류와 협력을 바탕으로 하는 제반의 실천을 이어가는 마중물의 역할을 수행하고자 합니다. 
							<br/><br/>
							이를 위해 
							<br/><br/>
							지역아동센터를 비롯해 지역사회의 다양한 청소년 배움터의 교육 복지 활동의 프로그램 개발, 운영지원 등을 위한 교육복지 지원 사업
							아동과 청소년 성장지원을 돕고 있는 참여자들의 지적, 정신적 성장을 돕기 위한 교육 사업
							아동과 청소년의 성장 지원을 돕고 있는 참여자들의 쉼과 교류, 소통 강화를 위한 다양한 문화 사업
							또한 이를 가능하게 할 모든 돌봄과 생명 나눔의 가치로 사회적 실천의 가능한 모든 상상과 실천으로 사람과 지역 사회의 그물을 엮어가는 
							실천사업을 수행하고자 합니다.  
						</div>
						 <div class="tab-cont2">
							<img src="/img/5.png" alt="교육나눔꿈두레">
						</div>
					</div>
	                </li>
	            </ul>
	        </li>
	        <li class="tab2">
	        	<a href="#link"><img src="/img/tab-2-off.png" alt="메뉴02" /></a>
	            <ul class="tabcontent">
	                <li><a href="#"></a>
	                <div class="tab-cont3">
						<h3 class="cont1">이사진 소개</h3><br/>
						<table class="tab_table">
							<tr>
								<th width="20%">이사장</th>			
								<td style="width:10%; text-align:center">오일화</td>
								<td width="70%">함께여는 청소년학교 지역아동센터 시설장 / 성남청소년지원네트워크 사무국장</td>
							</tr>
							<tr>
								<th rowspan="10">이사</th>
								<td style="width:10%; text-align:center">권정수</td>
								<td>도담 분당동 시립 지역아동센터 시설장</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:center">김보민</td>
								<td>별빛등대 대표 / 군포아동청소년지원네트워크 대표</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:center">김현정</td>
								<td>카르페디옴 지역아동센터 시설장</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:center">박찬식</td>
								<td>쉼과 배움으로 함께하는 교사학교 교장 /충북대학교</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:center">박희주</td>
								<td>샘터 지역아동센터 시설장</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:center">백재은</td>
								<td>시흥아동청소년지원네트워크 사무국장</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:center">엄미경</td>
								<td>무지개빛청개구리 대표교사</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:center">이윤복</td>
								<td>즐거운가 대표</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:center">정경</td>
								<td>사)더불어함께 대표</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:center">한석원</td>
								<td>깊은 생각 수학학원 원장</td>
							</tr>
							<tr>
								<th rowspan="2">감사</th>
								<td style="width:10%; text-align:center">양용준</td>
								<td></td>
							</tr>
							<tr>
								<td style="width:10%; text-align:center">손명균</td>
								<td>함께여는 청소년학교 실무교사</td>
							</tr>
						</table>
						<br/><br/>
						<h3 class="cont1">상근진 소개</h3><br/>
						<table class="tab_table">
							<tr>
								<th rowspan="3" width="20%">교육나눔<br/>꿈두레</th>			
								<td style="width:10%; text-align:center">상임이사</td>
								<td width="70%">김보민</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:center">상근자</td>
								<td>권명주</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:center">상근자</td>
								<td>조혜미</td>
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
    $(document).ready(function(){
        $(".tabmenu").each(function(){
            var tab = $(this).children("ul");
            var tabBtn = tab.children("li").children("a");
            var content = tabBtn.nextAll();
            
            // 탭버튼을 클릭했을때
            tabBtn.click(function(){
                // 이미 on 상태면 pass
                if( $(this).hasClass("on") ) return;
                // 모든 컨텐츠 부분을 안보이게 한뒤
                content.hide();
                // 클릭한 tab 버튼(a태그) 옆의 모든 태그들은 보이도록
                $(this).nextAll().show();
                // 모든탭 버튼에 있던 on 클래스를 빼고
                // 현재 클릭한 탭메뉴 버튼에 on 클래스 추가
                tabBtn.removeClass("on");
                $(this).addClass("on");                 
                // 탭버튼를 쭉 돌면서 on 클래스가 있는 버튼만 on 이미지로 바꾸고
                // 나머지 버튼들은 off 이미지로 바꾼다.
                tabBtn.each(function(){
                    var src;
                    var img = $(this).children("img");
                    if( $(this).hasClass("on") ){
                        src = img.attr("src").replace("-off.", "-on.");
                    }else{
                        src = img.attr("src").replace("-on.", "-off.");
                    }
                    img.attr("src", src);
                });
            });
            // 맨첫번째 탭버튼 클릭처리
            tabBtn.eq(0).click();
        });
    });
</script>
</body>
</html>