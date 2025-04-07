Service faz parte de uma organização conhecida como arquitetura em camadas.

Ela ajuda a separar responsabilidades, deixar o código mais limpo, organizado e fácil de manter.

service – Regra de negócio

    Aqui fica a lógica que não é nem do banco, nem da API.

    É onde você centraliza operações mais complexas, validações, cálculos, etc.

    A controller chama o service pra fazer o trabalho pesado.

Cozinha – prepara a comida (lógica de negócio)