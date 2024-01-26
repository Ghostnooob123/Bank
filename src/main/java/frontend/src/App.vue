<template>

  <div id="app">
    <h1>
      Todor Kolev
    </h1>
    <button @click="getAccounts">Get posts</button>
    {{accounts}}
  </div>

</template>

<script>
import axios from 'axios'

export  default {
 name: 'App',

  data() {
   return {
     accounts: null
   }
  },

  methods: {
    async getAccounts() {
      this.accounts = await axios.get('http://localhost:8080/api/v1/bank')
    }
  }

}
</script>