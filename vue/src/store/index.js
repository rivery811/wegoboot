import Vue from 'vue'
import Vuex from 'vuex'
//import axios from 'axios'

Vue.use(Vuex)

export const store = new Vuex.Store({
  state: {
/* 	loginedId:'',
	loginedPwd:'',
	id:'',
	name:'',
	birthday:'',
	gender:'',
	hak:'',
	ban:'',
	score:'' */
	person:{},
	authCheck:false
  }
})