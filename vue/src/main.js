import Vue from 'vue'
import App from './App.vue'
import router from './router'
import 'es6-promise/auto'
import axios from 'axios'
import vuex from 'vuex'
import vueElementLoading from 'vue-element-loading'
import {store} from './store'


Vue.config.productionTip = false
Vue.prototype.$http = axios

new Vue({
  render: h => h(App),
  router,
  axios,
  vuex,
  vueElementLoading,
  store
}).$mount('#app')

