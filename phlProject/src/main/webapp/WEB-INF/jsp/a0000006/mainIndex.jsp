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
 <link rel='stylesheet' id='camera-css'  href='/css/camera.css' type='text/css' media='all'> 
    <style>
		body {
			margin: 0;
			padding: 0;
		}
		a {
			color: #09f;
		}
		a:hover {
			text-decoration: none;
		}
		#back_to_camera {
			clear: both;
			display: block;
			height: 80px;
			line-height: 40px;
			padding: 20px;
		}
		.fluid_container {
			margin: 0 auto;
			max-width:1100px;
			width: 100%;
			overflow: hidden;
		}
	</style>
	<script type='text/javascript' src='/js/jquery.min.js'></script>
    <script type='text/javascript' src='/js/jquery.mobile.customized.min.js'></script>
    <script type='text/javascript' src='/js/jquery.easing.1.3.js'></script> 
    <script type='text/javascript' src='/js/camera.min.js'></script> 
    
    <script>
		jQuery(function(){
			
			jQuery('#camera_wrap_1').camera({
				thumbnails: true
			});

		});
	</script>
</head>
<body>   
	<div class="fluid_container">
        <div class="camera_wrap camera_azure_skin" id="camera_wrap_1">
            <div data-thumb="/img/slides/thumbs/bridge.jpg" data-src="/img/slides/bridge.jpg">
                <div class="camera_caption fadeFromBottom">
                    Camera is a responsive/adaptive slideshow. <em>Try to resize the browser window</em>
                </div>
            </div>
            <div data-thumb="/img/slides/thumbs/leaf.jpg" data-src="/img/slides/leaf.jpg">
                <div class="camera_caption fadeFromBottom">
                    It uses a light version of jQuery mobile, <em>navigate the slides by swiping with your fingers</em>
                </div>
            </div>
            <div data-thumb="/img/slides/thumbs/road.jpg" data-src="/img/slides/road.jpg">
                <div class="camera_caption fadeFromBottom">
                    <em>It's completely free</em> (even if a donation is appreciated)
                </div>
            </div>
            <div data-thumb="/img/slides/thumbs/sea.jpg" data-src="/img/slides/sea.jpg">
                <div class="camera_caption fadeFromBottom">
                    Camera slideshow provides many options <em>to customize your project</em> as more as possible
                </div>
            </div>
            <div data-thumb="/img/slides/thumbs/shelter.jpg" data-src="/img/slides/shelter.jpg">
                <div class="camera_caption fadeFromBottom">
                    It supports captions, HTML elements and videos and <em>it's validated in HTML5</em> (<a href="http://validator.w3.org/check?uri=http%3A%2F%2Fwww.pixedelic.com%2Fplugins%2Fcamera%2F&amp;charset=%28detect+automatically%29&amp;doctype=Inline&amp;group=0&amp;user-agent=W3C_Validator%2F1.2" target="_blank">have a look</a>)
                </div>
            </div>
            <div data-thumb="/img/slides/thumbs/tree.jpg" data-src="/img/slides/tree.jpg">
                <div class="camera_caption fadeFromBottom">
                    Different color skins and layouts available, <em>fullscreen ready too</em>
                </div>
            </div>
        </div><!-- #camera_wrap_1 -->	
      </div>
	  <div id="main_content">
	  	<div class="content-1">	
			<h3>Content</h3>
	        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec mollis nulla. 
	        Phasellus lacinia tempus mauris eu laoreet. Proin gravida velit dictum dui consequat malesuada. 
	        Aenean et nibh eu purus scelerisque aliquet nec non justo. Aliquam vitae aliquet ipsum. 
	        Etiam condimentum varius purus ut ultricies. Mauris id odio pretium, sollicitudin sapien eget, adipiscing risus.</p>
      	</div>
      	<!-- <div class="content-2">	
			<div class="box-cont"></div>
			<div class="box-cont"></div>
			<div class="box-cont"></div>
      	</div> -->
      </div>
      <div id="main_sidebar">
        <h3>Sidebar</h3>
        <ul>
          <li><a href="#">Lorem</a></li>
          <li><a href="#">Ipsum</a></li>
          <li><a href="#">Dolor</a></li>
        </ul>
      </div>
</body>
</html>