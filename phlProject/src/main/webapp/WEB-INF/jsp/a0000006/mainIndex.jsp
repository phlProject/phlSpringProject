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
<script type='text/javascript' src='/js/jquery.mobile.customized.min.js'></script>
<script type='text/javascript' src='/js/jquery.easing.1.3.js'></script> 
<script type='text/javascript' src='/js/camera.min.js'></script> 


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
		}
	</style>
    
    
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
			<div data-thumb="/img/slides/thumbs/bridge.jpg" 	data-src="/img/slides/bridge.jpg"></div>
			<div data-thumb="/img/slides/thumbs/leaf.jpg" 		data-src="/img/slides/leaf.jpg"></div>
			<div data-thumb="/img/slides/thumbs/road.jpg" 		data-src="/img/slides/road.jpg"></div>
			<div data-thumb="/img/slides/thumbs/sea.jpg" 		data-src="/img/slides/sea.jpg"></div>
			<div data-thumb="/img/slides/thumbs/shelter.jpg" 	data-src="/img/slides/shelter.jpg"></div>
			<div data-thumb="/img/slides/thumbs/tree.jpg" 		data-src="/img/slides/tree.jpg"></div>
		</div>
	</div>
	
	<div id="main_content">
		<div class="content-1">	
		
	  	</div>
   	</div>
    
    <div id="main_sidebar">
    	<div class="sidebar-1">
      		<a href="javascript:TopMenuMove('/a0000006/intro/sponsor.do');">
      		<img src="/img/sidebar7.png"  alt="sponsor"/>      		
      		</a>
      	</div>
      	<div class="sidebar-2">
      		
      	</div>
      	<div class="sidebar-3">
      		<a href="#"><img src="/img/books.jpg" alt="books"></a>
      	</div>
      </div>
</body>
</html>