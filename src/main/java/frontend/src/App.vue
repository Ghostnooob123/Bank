<template>

  <div id="app">
    <button @click="getAccounts">Get accounts button</button>

    <p></p>

    <table style="width:100%">
      <tr>
        <th>Edit</th>
        <th>Account Name</th>
        <th>Account Credit_Debit_Card</th>
        <th>Account Balance</th>
        <th>Account Status</th>
        <th>Account Date of birth</th>
      </tr>
      <tr v-for="account in accounts" :key="account.accountHolder_uniqueId">
        <td>
          <button @click="editAccount(account)">
            Edit
          </button>
        </td>
        <td>
          <input v-model="account.accountHolder_Name" type="text">
        </td>
        <td>{{ account.accountHolder_Credit_Debit_Card }}</td>
        <td>
          <input v-model="account.accountHolder_Balance" type="text">
        </td>
        <td>{{ account.accountHolder_Status }}</td>
        <td>{{ account.accountHolder_Dob }}</td>
      </tr>
    </table>

    <p></p>

    <button @click="reset"> Reset </button>

    <p></p>

    <button @click="register"> Register</button>
  </div>

</template>

<script>
import axios from 'axios'

export  default {
  name: 'App',

  data() {
    return {
      accounts: null,
      buttonClicked: 0,
    }
  },
  methods: {
    async getAccounts() {
      try {
        const response = await axios.get('http://localhost:8082/api/v1/bank'); // replace with your actual API endpoint
        if (this.buttonClicked == 0){
          this.accounts = response.data;
          this.buttonClicked = 1;
        }
        console.log(response)
      } catch (error) {
        console.error('Error fetching accounts:', error);
      }
    },
    async editAccount(account) {
      try {
        const response = await axios.put(
            `http://localhost:8082/api/v1/bank/${account.accountHolder_uniqueId}`,
            {
              accountHolder_Balance: Number(account.accountHolder_Balance),
              accountHolder_Name: account.accountHolder_Name.toString()
            });

        console.log(response);
        if (response.request.status == 200) {
          alert("Work")
        }
      } catch (error) {
        console.error('Error editing account:', error);
      }
    },
    async reset() {
      try {
        const response = await axios.get('http://localhost:8082/api/v1/bank'); // replace with your actual API endpoint
        this.accounts = response.data;

        console.log(response)
      } catch (error) {
        console.error('Error fetching accounts:', error);
      }
    },
    async register() {
      try {
        const response = await axios.post(
            'http://localhost:8082/api/v1/bank',
            {
              accountHolder_Balance: Number(111),
              accountHolder_Name: 'Ivo'
            });

        console.log(response);
      } catch (error) {
        console.error('Error editing account:', error);
      }
    }
  }
}
</script>

<style>
table, th, td {
  border: 1px solid #000000;
}
</style>