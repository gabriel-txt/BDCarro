## 🚗 Sistema de Cadastro de Carros com Serialização em Java

Este é um projeto simples em Java que utiliza **serialização de objetos** para armazenar informações sobre carros em um arquivo. O programa permite que o usuário insira dados de um carro (marca, modelo e cor) e os salve em um "mini banco de dados" (arquivo escolhido pelo usuário).  

### 📌 Funcionalidades  
- Solicitação de informações do carro via interface gráfica (JOptionPane).  
- Armazenamento dos dados em um arquivo utilizando **serialização de objetos**.  
- Leitura dos objetos armazenados no arquivo e exibição das informações na tela.  
- Uso de um `AppendableObjectOutputStream` para evitar a sobrescrita do cabeçalho do arquivo ao adicionar novos objetos.  

### 🛠️ Tecnologias Utilizadas  
- **Java SE**  
- **Swing (JOptionPane) para entrada de dados**  
- **Manipulação de arquivos com `ObjectOutputStream` e `ObjectInputStream`**  

### 📂 Estrutura do Projeto  
```
📂 src
 ├── 📄 Main.java                     // Classe principal do programa
 ├── 📄 Carro.java                    // Classe que representa um carro e implementa Serializable
 ├── 📄 AppendableObjectOutputStream.java // Classe para evitar sobrescrita de cabeçalho no arquivo
```

### 🚀 Como Executar  
1. **Compile o projeto:**  
   ```sh
   javac src/*.java
   ```
2. **Execute o programa:**  
   ```sh
   java src.Main
   ```
3. **Interaja com a aplicação:**  
   - Insira os dados do carro através das caixas de diálogo.  
   - Escolha um arquivo para armazenar os dados.  
   - Veja os dados armazenados exibidos no console.  

### 📌 Exemplo de Saída  
```
Carro 0: [Marca: Toyota] [Modelo: Corolla] [Cor: Preto]
Carro 1: [Marca: Honda] [Modelo: Civic] [Cor: Branco]
```

### 📜 Licença  
Este projeto é de código aberto e pode ser utilizado para estudos e melhorias.  
