import Vue from 'vue'
import Router from 'vue-router'

import Login from '@/components/member/Login.vue'
import Join from '@/components/member/Join.vue'
import Write from '@/components/border/Write.vue'
import List from '@/components/border/List.vue'
import Update from '@/components/border/Update.vue'
import Remove from '@/components/border/Remove.vue'
import Search from '@/components/border/Search.vue'
import MyPage from '@/components/member/MyPage.vue'
import MyPageUpdate from '@/components/member/MyPageUpdate.vue'


Vue.use(Router)

export default new Router({
	mode : 'history',
	routes :[

		{path : '/login', name : 'login',component: Login},
		{path : '/join', name : 'join',component: Join},
		{path : '/write', name : 'write',component: Write},
		{path : '/list', name : 'list',component: List},
		{path : '/update', name : 'update',component: Update},
		{path : '/remove', name : 'remove',component: Remove},
		{path : '/search', name : 'search',component: Search},
		{path : '/mypage', name : 'mypage',component: MyPage},
		{path : '/mypageupdate', name : 'mypageupdate',component: MyPageUpdate},




	]
}) 