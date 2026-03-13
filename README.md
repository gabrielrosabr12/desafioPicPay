<h1 align="center" syle="font-weight: bold;"> PicPay Challenge with Spring ✅</h1>

<p align="center">
  <a href="#tech">Technologies</a> •
  <a href="#started">Get Started</a> •  
  <a href="#routes">Api Endpoints</a> •
  <a href="#colab">Collaborators</a> •
  <a href="#reference">Reference</a> •
</p>

<p align="center">
  <b>A project to practice Spring, requests, validations, and exceptions with Java.</b>
</p>

<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/5/5e/PicPay_Logogrande.png" width="50%" alt="logo picpay" align="center"/>
</p>

<h2 id="tech">💻 Technologies</h2>

- Java

<h2 id="started">🚀 Getting started</h2>

  To run the project locally, you will need to follow these steps.

<h3>Prerequisites</h3>

Here you list all prerequisites necessary for running your project. For example:

- [Git 2](https://github.com)

<h3>Cloning</h3>

```bash
git clone https://github.com/gabrielrosabr12/desafioPicPay.git
```

<h2 id="routes">📍 API Endpoints</h2>
  
| routes                     | description 
|----------------------------|------------
| <kbd> POST /wallets </kbd> | Create a wallet in the database. [response details.](#get-wallet-detail)
| <kbd> POST /transfer </kbd>| Create a new transfer between users. [response details.](#get-transfer-detail)


<h3 id="get-wallet-detail">POST /wallets</h3>

```json
{
    "fullName":"gabriel",
    "cpfCnpj":"123456789",
    "email":"gabriel@email.com",
    "password":"123456",
    "walletType":"USER"
}
```

<h3> RESPONSE /wallets</h3>

```json
{
    "fullName": "gabriel",
    "cpfCnpj": "123456789",
    "email": "gabriel@email.com",
    "password": "123456",
    "walletType": {
        "id": 1,
        "description": "user"
    },
    "balance": 0,
    "id": 1,
    "transferAllowedForWalletType": true
}
```


<h3 id="get-transfer-detail">POST /transfer</h3>

```json
{
    "value":20,
    "payer": 1,
    "payee": 2
}
```

<h3> RESPONSE /transfer</h3>

```json
{
    "sender": {
        "fullName": "gabriel",
        "cpfCnpj": "123",
        "email": "gabriel@gmail.com",
        "password": "123",
        "walletType": {
            "id": 1,
            "description": "user"
        },
        "balance": 30.00,
        "id": 1,
        "transferAllowedForWalletType": true
    },
    "receiver": {
        "fullName": "joao",
        "cpfCnpj": "1234",
        "email": "joao@gmail.com",
        "password": "123",
        "walletType": {
            "id": 1,
            "description": "user"
        },
        "balance": 20.00,
        "id": 2,
        "transferAllowedForWalletType": true
    },
    "value": 20,
    "id": "1cb44ead-2985-48ab-9951-9c4e7697b113"
}
```

<h2 id="colab">Collaborators</h2>
<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/186586436?s=96&v=4" width="100%;" alt="Gabriel Rosa Barbosa">
        <sub>
          <b>Gabriel Rosa</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

<h2 id="reference">Reference</h2>

Link to the challenge rules and requirements. [Challenge PicPay](https://github.com/PicPay/picpay-desafio-backend?tab=readme-ov-file#materiais-%C3%BAteis)


This project was created by studying the Build Run Tech video. [@buildrun-tech](https://github.com/buildrun-tech)


<details>
  <summary>🎥 Click to view the video for tutorial.</summary>
  <br>
  <a href="https://youtu.be/dttXo48oXt4?si=Bikwj1uTgPs5VTep">
    <img src="https://i.ytimg.com/vi/dttXo48oXt4/maxresdefault.jpg" width="600">
  </a>
</details>


