<template>
  <div class="back">
     <div align = "center"><h1><input type="text" v-model="person.name"/>님의 Mypage</h1> </div>
      <div class="sub">
        <div class="pull-left rt size" >
           <fieldset style=" margin-top: 1%; height: 31.5%;border: 2px solid black;">
             <legend><h3>비밀번호 변경</h3></legend>
                <input type="text" name="pwd" size="20" placeholder="기존 비밀번호 입력" v-model="person.pwd"  style="float: none; width: 70%;">
                <button style="height: 38%; width: 20%; float: right;">수정</button><br/><br/>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 60%;border: 2px solid black;">
              <legend><h3>학생부관리</h3></legend>
               
                <input type="text" name="pwd" size="20" placeholder="변경할 학년  입력" v-model="person.hak" style="float: none;width: 70%;">
                <input type="text" name="pwd" size="20" placeholder="변경할 반 입력" v-model="person.ban"  style="float: none;width: 70%;">
                <input type="text" name="pwd" size="20" placeholder="변경할 성적 입력" v-model="person.score"   style="float: none;width: 70%;">
                <br/><br/>
           </fieldset>
        </div>
      </div>
    </div>
</template>
<script>
import axios from 'axios'
import {store} from "../../store"

export default{
  data(){
    return {
      context:'http://localhost:8080/',
      person : store.state.person,     
    }
  },
  create(){
  },
  methods:{

      modify(){
      let url=`${this.context}/update/${store.state.person.userid}`
			let data=this.person
			let headers= {
				'authorization': 'JWT fefege..',
				'Accept' : 'application/json',
				'Content-Type': 'application/json'
      }
        axios
        .put(url, data, headers)
        .then(()=>{})
        .catch(()=>{})

      }
  }

}

</script>
 <style scoped>
    .back {width: 1100px; margin: 0 auto;}
    .sub {width: 70%; height: 600px; margin: 0 auto; text-align: center;}
    .pull-left {float: left;}
    .pull-right {float: right;}
    .top {margin-top: 1%;}
    .rt {margin-right: 1%;}
    .size {width: 49.5%; height: 100%;}
</style>