 <template>
 <div class ="join">
    <form >
       <div class="form-group" >
            <label for="name">id</label>
            <input type="text" id="id" class="form-control" v-model="id" required>
          
        </div>
        <div >
            <label for="email">uID</label>
            <input type="email" id="uid" class="form-control"  v-model="userid" required>
          
        </div>
        <div class="form-group" >
            <label for="name">Name</label>
            <input type="text" id="name" class="form-control" v-model="name" required>
          
        </div>

        <div >
            <label for="password">Password</label>
            <input type="password" id="password" class="form-control" v-model="passwd" required>
          
        </div>
        <div>
            <label for="password">생일</label>
            <input type="text" id="birth" class="form-control" v-model="birthday" required>
            
        </div>
        <button @click.prevent="register" type="submit" class="btn btn-default">Submit</button>
    </form>
  </div>
</template>

<script>
import axios from "axios"

export default {
  data(){
    return{
      context:'http://localhost:8080/',
        id:'',
        userid:'',
        passwd: '',
        name: '',
        birthday :''}
        
    

    
  },
  methods:{
    register(){
      alert(this.birthday)
      alert(this.name)
      let url=`${this.context}/join`
			let data={
        userid:this.userid,
        passwd: this.passwd,
        name: this.name,
        birthday :this.birthday}
			let headers= {
				'authorization': 'JWT fefege..',
				'Accept' : 'application/json',
				'Content-Type': 'application/json'
      }
      axios
			.post(url,data,headers)
			.then(respose=>{ 
          alert(respose.data.result)
          if(respose.data.result==="success"){
              this.$router.push('login')
          }else{
            this.$router.push('join')
          }

			})
			.catch(()=>{
				alert('dpftldhtm tlfvo')
			}) 

    }
  }

}
</script>
<style scoped>
.join{
  
  padding-top:5px;
  padding-left:5px;
  padding-right:5px;
  padding-bottom:5px
}
</style>