<template>
  <div class="container">
    <h1>Lista de Usuários</h1>

    <!-- Formulário para adicionar ou editar usuários -->
    <form @submit.prevent="handleSubmit">
      <input v-model="form.name" placeholder="Nome" required />
      <input v-model="form.email" placeholder="Email" required />
      <button type="submit">
        {{ form.id ? 'Atualizar' : 'Adicionar' }}
      </button>
    </form>

    <!-- Lista de usuários -->
    <ul>
      <li v-for="user in users" :key="user.id">
        {{ user.name }} ({{ user.email }})
        <button @click="editUser(user)">Editar</button>
        <button @click="deleteUser(user.id)">Excluir</button>
      </li>
    </ul>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue'

export default {
  setup() {
    // Lista de usuários
    const users = ref([])

    // Dados do formulário (vazio inicialmente)
    const form = ref({ id: null, name: '', email: '' })

    // URL base da API (substitua pela sua)
    const API_URL = 'http://localhost:8080/api/usuarios'

    // Função para buscar todos os usuários
const fetchUsers = async () => {
  try {
    const res = await fetch(API_URL)
    const contentType = res.headers.get('content-type')
    console.log('Conteúdo recebido da API:', contentType)

    if (contentType && contentType.includes('application/json')) {
      const data = await res.json()
      console.log('Usuários recebidos:', data)
      users.value = data
    } else {
      const text = await res.text()
      console.error('Resposta da API não é JSON:', text)
    }
  } catch (err) {
    console.error('Erro ao buscar usuários:', err)
  }
}



    // Função para adicionar ou atualizar um usuário
const handleSubmit = async () => {
  const method = form.value.id ? 'PUT' : 'POST'
  const url = form.value.id ? `${API_URL}/${form.value.id}` : API_URL
  const payload = JSON.stringify(form.value)

  console.log(`[${method}] Enviando para:`, url)
  console.log('Dados enviados:', payload)

  try {
    const res = await fetch(url, {
      method,
      headers: { 'Content-Type': 'application/json' },
      body: payload,
    })

    console.log('Status da resposta:', res.status)

    const contentType = res.headers.get('content-type')
    if (contentType && contentType.includes('application/json')) {
      const data = await res.json()
      console.log('Resposta JSON:', data)
    } else {
      const text = await res.text()
      console.warn('Resposta não JSON:', text)
    }

    await fetchUsers()
    form.value = { id: null, name: '', email: '' }
  } catch (err) {
    console.error('Erro ao enviar formulário:', err)
  }
}



    // Carrega dados no formulário para edição
    const editUser = (user) => {
      form.value = { ...user }
    }

    // Deleta usuário
    const deleteUser = async (id) => {
      await fetch(`${API_URL}/${id}`, {
        method: 'DELETE',
      })
      await fetchUsers()
    }

    // Quando o app iniciar, carrega os usuários
    onMounted(fetchUsers)

    return { users, form, handleSubmit, editUser, deleteUser }
  },
}
</script>

<style>
.container {
  max-width: 600px;
  margin: 2rem auto;
  font-family: Arial, sans-serif;
}
input {
  margin: 0.5rem;
}
button {
  margin-left: 0.5rem;
}
</style>
