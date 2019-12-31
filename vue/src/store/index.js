import Vue from 'vue'
import Vuex from 'vuex'

import admin from '@/store/modules/admin'
import common from '@/store/modules/common'
import students from '@/store/modules/students'
import article from '@/store/modules/article'
Vue.use(Vuex)

/* export const store = new Vuex.Store({
  state: {
	person:{},
	authCheck:false,
	sidebar:'',
	headermsg :'공통화면'
  }
}) 뷰엑스전 */


export const store = new Vuex.Store({
	modules:{
		students,
		article,
		admin,
		common
	},
	strict:true

})