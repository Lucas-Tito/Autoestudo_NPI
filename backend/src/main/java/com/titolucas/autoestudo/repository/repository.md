Repository faz parte de uma organização conhecida como arquitetura em camadas.

Ela ajuda a separar responsabilidades, deixar o código mais limpo, organizado e fácil de manter.

repository – Acesso ao banco de dados

    Contém interfaces que estendem JpaRepository (ou CrudRepository).

    Elas cuidam de buscar, salvar, deletar e atualizar dados no banco.

    O Spring gera automaticamente o código SQL por baixo dos panos.

Despensa – onde estão os ingredientes (dados)