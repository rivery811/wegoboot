<template>
<div id ="wrapper"> 
	<header>	
		<slot name="header" :title ="headermsg"></slot>	
	</header>
	<aside id ="sidebar">
		<slot name="sidebar"></slot>
	</aside>
	<section id="content">   
		<slot name="content" :msg="content"></slot>
	</section>
	<footer>
		<slot name="footer" :msg="footer" ></slot>
	</footer>
	
</div>
</template>
<script>
import {store} from "../../store"
export default{

	data(){
		return{
			content:"내용",
			footer:"footer"
					
	}
},
computed:{
     headermsg(){         
          return store.state.headermsg


     }
}
}
</script>
<style scoped>
#wrapper {
     padding: 5px;
     width: 960px;
     margin: 20px auto;
}
header {
     height: 100px;
     padding: 0 15px;
}
#content {
     width: 696px;
     float: left;
     padding: 5px 15px;
    min-height: 300px;
}
#sidebar {
     width: 200px;
     padding: 5px 15px;
     float: left;
}
footer {
     clear: both;
     padding: 0 15px;
}
/* 가로폭 980보다 작을 때 사용할 @media query */
@media screen and (max-width: 980px) {     
     #wrapper {
           width: 94%;
     }
     #content {
           clear: both;
           padding: 1% 4%;
           width: auto;
           float: none;
     }
     #sidebar {
           clear: both;
           padding: 1% 4%;
           width: auto;
           float: none;
     }
     header, footer {
           padding: 1% 4%;
     }
}
/* 공통 */
#content {
     background: #f8f8f8;
}
#sidebar {
     background: #f0efef;
}
header, #content, #middle, #sidebar {
     margin-bottom: 5px;
}
#wrapper, header, #content, #middle, #sidebar, footer {
     border: solid 1px #ccc;
}

</style>