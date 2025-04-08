<template>
  <v-app>
    <v-main>
      <v-container>
        <h1 class="text-h4 mb-4">Lista de Usuários</h1>

        <!-- Formulário para adicionar ou editar usuários -->
        <v-form @submit.prevent="handleSubmit">
          <v-text-field
            v-model="form.name"
            label="Nome"
            outlined
            required
            class="mb-4"
          />
          <v-text-field
            v-model="form.email"
            label="Email"
            outlined
            required
            class="mb-4"
          />
          <v-btn type="submit" color="primary" class="mb-4">
            {{ form.id ? 'Atualizar' : 'Adicionar' }}
          </v-btn>
        </v-form>

        <!-- Lista de usuários -->
        <v-list>
          <v-list-item
            v-for="user in users"
            :key="user.id"
            class="d-flex justify-space-between align-center"
          >
            <div>
              {{ user.name }} ({{ user.email }})
            </div>
            <div>
              <v-btn small color="info" @click="editUser(user)">Editar</v-btn>
              <v-btn small color="error" @click="deleteUser(user.id)">Excluir</v-btn>
            </div>
          </v-list-item>
        </v-list>
      </v-container>
    </v-main>
  </v-app>
</template>

<script lang="ts" setup>
import { ref, onMounted } from 'vue'

// Lista de usuários
const users = ref<{ id: number; name: string; email: string }[]>([])

// Dados do formulário (vazio inicialmente)
const form = ref<{ id: number | null; name: string; email: string }>({
  id: null,
  name: '',
  email: '',
})

// URL base da API (substitua pela sua)
const API_URL = 'http://localhost:8080/api/usuarios'

// Função para buscar todos os usuários
const fetchUsers = async () => {
  try {
    const res = await fetch(API_URL)
    if (res.ok) {
      users.value = await res.json()
    } else {
      console.error('Erro ao buscar usuários:', res.statusText)
    }
  } catch (err) {
    console.error('Erro ao buscar usuários:', err)
  }
}

// Função para adicionar ou atualizar um usuário
const handleSubmit = async () => {
  const method = form.value.id ? 'PUT' : 'POST'
  const url = form.value.id ? `${API_URL}/${form.value.id}` : API_URL

  try {
    await fetch(url, {
      method,
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(form.value),
    })
    await fetchUsers()
    form.value = { id: null, name: '', email: '' }
  } catch (err) {
    console.error('Erro ao enviar formulário:', err)
  }
}

// Carrega dados no formulário para edição
const editUser = (user: { id: number; name: string; email: string }) => {
  form.value = { ...user }
}

// Deleta usuário
const deleteUser = async (id: number) => {
  try {
    await fetch(`${API_URL}/${id}`, { method: 'DELETE' })
    await fetchUsers()
  } catch (err) {
    console.error('Erro ao deletar usuário:', err)
  }
}

// Quando o app iniciar, carrega os usuários
onMounted(fetchUsers)
</script>

<style scoped>
h1 {
  font-family: Arial, sans-serif;
}
</style>