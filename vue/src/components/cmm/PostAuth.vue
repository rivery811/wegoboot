<template>
<div id ="auth-box"> 
	<h5 @click.prevent="logout">로그아웃</h5>
	<h5 @click.prevent="withdrawal">회원탈퇴</h5>
	
</div>
</template>
<script>
import axios from 'axios'
import {store} from "../../store"
export default{

	data(){
	return{
          context:'http://localhost:8080/'
     }
					
     },
     
  methods:{
      logout(){
        store.state.person.id =''
        store.state.person.userid =''
        store.state.person.passwd =''
        store.state.person.name =''
        store.state.person.birthday =''
        store.state.person.gender =''
        store.state.person.hak =''
        store.state.person.ban =''
        store.state.person.score ='' 
        this.$router.push('login')
        },
      withdrawal(){
        alert('withdrawal') 
        alert(store.state.person.userid)  
        axios
        .delete(`${this.context}/withdrawal/${store.state.person.userid}`)
        .then(()=>{
          alert('axios s')
          store.state.authCheck=false
          this.$router.push('login')
        })
        .catch(()=>{
          alert('axios fail')
        })
      }
  }

}
</script>
<style scoped>

</style>