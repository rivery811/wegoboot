<template>
	<div >	
		<layout>			
			<template #header="header">
				<h1>{{header.title}}</h1>
				<component :is="!loginCheck ?'pre-auth':'post-auth'"></component>
					
			</template>
			<template #sidebar="sidebar">
						<component :is="sidebarkind" >Large</component>			

				<!-- <ul class="menu">
					<li v-for="i of sidebars" :key="i.menu">
						<router-link :to="i.link">{{i.menu}}</router-link>					
					</li>
				</ul> -->
			</template>
			<template #content="content">
				
				<router-view/>    
			</template>
			<template #footer="footer">
				<h1>{{footer.msg}}</h1>
			</template>
		</layout>
	</div>
</template>
<script>
import {store} from "../store"
import Layout from '@/components/cmm/Layout.vue'
import PreAuth from '@/components/cmm/PreAuth.vue'
import PostAuth from '@/components/cmm/PostAuth.vue'
import StudentSidebars from '@/components/cmm/StudentSidebars.vue'
import TeacherSidebars from '@/components/cmm/TeacherSidebars.vue'
import ManagerSidebars from '@/components/cmm/ManagerSidebars.vue'


export default{
	components :{Layout,PreAuth,PostAuth,StudentSidebars,TeacherSidebars,ManagerSidebars
	
	},
	data(){

		return{
			sidebars:[
				{menu:"글쓰기",link:"/write"},
				{menu:"목록",link:"/list"},
				{menu:"글수정",link:"/update"},
				{menu:"글삭제",link:"/remove"},
				{menu:"검색",link:"/search"},
			],
			//sidebarkind: store.state.sidebar
			
			
		
		}
	},
	computed:{	
		loginCheck: function(){			
			return store.state.authCheck
		},
		sidebarkind:function(){
			return store.state.sidebar
		}
	}
}
</script>
<style scoped>
ul.menu {
    position:relative;
    padding: 5px 5px 5px 5px;
    list-style: none;
    font-style: italic;
}
ul.menu a {
    text-decoration:none;
}</style>