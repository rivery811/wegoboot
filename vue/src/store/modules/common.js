import * as types from '@/store/modules/mutation_types'
const state={
		context:'http://localhost:8080/',
		isAuth:false,
		sidebar:'',
		headermsg :'공통화면',
		errorState:''
}
const getters={
	getErrorState :state =>state.getErrorState,
  getIsAuth : state => state.isAuth,
  getContext : state => state.context,
  getSidebar :state=> state.getSidebar,
  getHeadermsg : state=>state.headermsg
}
const actions={}
const mutations={
		[types.ERROR_STATE](state,errorState){
		state.errorState=errorState
	},
	[types.IS_AUTH](state,isAuth){
		state.isAuth=isAuth
	},
	[types.CONTEXT](state,context){
		state.context=context
	},
	[types.SIDEBAR](state,sidebar){
		state.sidebar=sidebar
	},
	[types.HEADERMSG](state,headermsg){
		state.headermsg=headermsg
	},
}
export default{
	namespaced:true,
	state,
	getters,
	actions,
	mutations
}