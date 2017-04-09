<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<link rel="stylesheet" href="/css/common.css" />
<link rel="stylesheet" href="/css/unit.css" />

<script src="/js/controller.js"></script>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/gsap/1.19.1/TweenMax.min.js"></script>
</head>
<body>


<div id="content">
<!-- <div style="background-image:url(/img/bg.png); width:100%; height: 400px; "> </div>-->
	<div id="slide" class="slide">
		<button class="prev" type="button"><img src="/img/left.png" alt=""></button>
			<ul>
				<li><img src="/img/image.jpg" alt=""></li>
	            <li><img src="http://placehold.it/1100x450" alt=""></li>
	            <li><img src="http://placehold.it/1100x450" alt=""></li>
	            <li><img src="http://placehold.it/1100x450" alt=""></li>
	            <li><img src="http://placehold.it/1100x450" alt=""></li>
			</ul>
		<button class="next" type="button"><img src="/img/right.png" alt=""></button>
	</div>
	<div id="underSlide">
		<section id="main_section">
			<article id="main_article">
				<h1>공지사항</h1>
				<div class="sec_one"><img src="http://placehold.it/255x150" /><p>공지1</p></div>
				<div class="sec_two"><img src="http://placehold.it/255x150" /><p>공지2</p></div>
				<div class="sec_three"><img src="http://placehold.it/255x150" /><p>공지3</p></div>
			</article>
			<article id="main_article2">
				<h1>소식</h1>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
				Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
				when an unknown printer took a galley of type and scrambled it to make a type
				specimen book. It has survived not only five centuries, but also the leap into
				electronic typesetting, remaining essentially unchanged. It was popularised
				in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,
				and more recently with desktop publishing software like Aldus PageMaker including
				versions of Lorem Ipsum.
				Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
				Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
				when an unknown printer took a galley of type and scrambled it to make a type
				specimen book. It has survived not only five centuries, but also the leap into
				electronic typesetting, remaining essentially unchanged. It was popularised
				in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,
				and more recently with desktop publishing software like Aldus PageMaker including
				versions of Lorem Ipsum.
				</p>
			</article>
			<article id="main_article">
				<h1>후기</h1>
				<div class="sec_one"><img src="http://placehold.it/255x150" /><p>후기1</p></div>
				<div class="sec_two"><img src="http://placehold.it/255x150" /><p>후기2</p></div>
				<div class="sec_three"><img src="http://placehold.it/255x150" /><p>후기3</p></div>
			</article>
		</section>		
		<aside id="main_aside">
			<input id="first" type="radio" name="tab" checked="checked" />
			<input id="second" type="radio" name="tab" />
			<section class="buttons">
				<label for="first">First</label>
				<label for="second">Second</label>
			</section>
			<div class="tab_item">
				<ul>
					<li class="item">
						<a href="#">
							<div class="thumbnail">
								<img src="http://placehold.it/45x45" />
							</div>
							<div class="description">
								<strong>HTML5 Canvas</strong>
								<p>2012-03-15</p> 
							</div>
						</a>
					</li>
					<li class="item">
						<a href="#">
							<div class="thumbnail">
								<img src="http://placehold.it/45x45" />
							</div>
							<div class="description">
								<strong>HTML5 Audio</strong>
								<p>2012-03-15</p> 
							</div>
						</a>
					</li>
					<li class="item">
						<a href="#">
						<div class="thumbnail">
							<img src="http://placehold.it/45x45" />
						</div>
						<div class="description">
							<strong>HTML5 Video</strong>
							<p>2012-03-15</p> 
						</div>
						</a>
					</li>
					<li class="item">
						<a href="#">
						<div class="thumbnail">
							<img src="http://placehold.it/45x45" />
						</div>
						<div class="description">
							<strong>HTML5 Semantic Web</strong>
						</div>
						</a>
					</li>
				</ul>
			</div>
			<div class="tab_item">
				<ul>
					<li class="item">
						<a href="#">
							<div class="thumbnail">
								<img src="http://placehold.it/45x45" />
							</div>
							<div class="description">
								<strong>CSS3 Transition</strong>
							</div>
						</a>
					</li>
					<li class="item">
						<a href="#">
							<div class="thumbnail">
								<img src="http://placehold.it/45x45" />
							</div>
							<div class="description">
								<strong>CSS3 Animation</strong>
							</div>
						</a>
					</li>
					<li class="item">
						<a href="#">
							<div class="thumbnail">
								<img src="http://placehold.it/45x45" />
							</div>
							<div class="description">
								<strong>CSS3 Border</strong>
							</div>
						</a>
					</li>
					<li class="item">
						<a href="#">
							<div class="thumbnail">
								<img src="http://placehold.it/45x45" />
							</div>
							<div class="description">
								<strong>CSS3 Box</strong>
							</div>
						</a>
					</li>
				</ul>
			</div>
		</aside>		
	</div>
</div>
</body>
</html>