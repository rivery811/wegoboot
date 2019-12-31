import Vue from 'vue'
import App from './App.vue'
import router from './router'
import 'es6-promise/auto'
import axios from 'axios'
import vuex from 'vuex'
//import vueElementLoading from 'vue-element-loading'
import {store} from './store'
import VSwitch from 'v-switch-case'
import VueGoogleCharts from 'vue-google-charts'

Vue.config.productionTip = false
Vue.prototype.$http = axios
Vue.use(VSwitch)
Vue.use(VueGoogleCharts)

new Vue({
  render: h => h(App),
  router,
  axios,
  vuex,
 // vueElementLoading,
  store,
  VSwitch,
  VueGoogleCharts
}).$mount('#app')

