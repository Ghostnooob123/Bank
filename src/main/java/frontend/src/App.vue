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
            Edit Confirm
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

    <p v-if="newRegister > 0">
      Reset the table
    </p>
    <p v-else-if="newRegister < 0">
      Up-To-Date
    </p>

    <button @click="reset"> Reset </button>

    <p></p>

    <button @click="register"> Register </button>
    <table style="width:100%">
      <tr>
        <th>Account Name</th>
        <th>Account Credit_Debit_Card</th>
        <th>Account Balance</th>
        <th>Account Date of birth</th>
      </tr>
      <tr>
        <td>
          <input v-model="this.name" type="text">
        </td>
        <td>
          <input v-model="this.card" type="text">
        </td>
        <td>
          <input v-model="this.balance" type="text">
        </td>
        <td>
          <input v-model="this.dob" type="date">
        </td>
      </tr>
    </table>

    <p/>

    <p>{{this.registerFailed}}</p>
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
      newRegister: 0,
      registerFailed:"",
      name: "",
      card: "",
      balance: 0.00,
      status: "Active",
      dob: null,
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

        this.newRegister = -1;

        console.log(response)
      } catch (error) {
        console.error('Error reset accounts:', error);
      }
    },
    async register() {
      try {
        let response = null;

        if (this.name != "" && this.card != "" && this.dob != null){
          response = await axios.post(
              'http://localhost:8082/api/v1/bank',
              {
                accountHolder_Name: this.name,
                accountHolder_Credit_Debit_Card: this.card,
                accountHolder_Balance: this.balance,
                accountHolder_Status: this.status,
                accountHolder_Dob: this.dob,
              });

          this.newRegister = 1;
          this.registerFailed = "";
        }
        else {
          this.registerFailed = "Fields need to be filled: Name, Card, Dob correctly.";
        }

        console.log(response);
      } catch (error) {
        console.error('Error register account:', error);
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