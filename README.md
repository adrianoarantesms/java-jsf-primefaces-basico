#Tutorial Básico para JavaWeb-Jsf-Primefaces
    
    Este tutorial tem como objetivo exemplificar uma visão básica e ao mesmo tempo ampla 
    no sentido de ver os dois mundos back-end e front-end. Vale lembrar que esse exemplo 
    é bem simples e não vamos se aprofundar em padrões de projetos, somente no que é preciso 
    para fazer funcionar uma aplicação java web com um modelo básico.

#####Para isso vamos precisar:
  
##
IDE Eclipse Mars 1 http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars2
##
Apache Tomcat 8 https://tomcat.apache.org/download-80.cgi
##
Java JDK 8 http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html?ssSourceSiteId=otnpt
##
MySql http://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-web-community-5.7.11.0.msi. Instale a opção Server, a configuração padrão de usuário é root senha root.
Mysql Workbench gerenciador para o MYSQL https://dev.mysql.com/downloads/workbench/
##
Instale também o MySql WorkBench para acessar e criar os "schemas". Esta no mesmo Instalador do MYSQL.
  
#####Para a instalação seguir os instaladores.
  
configurar as variaveis de ambiente:
 
##
JAVA_HOME = C:\Program Files\Java\jdk1.8.0_66 
##
PATH = %JAVA_HOME%\bin,..
##
ECLIPSE_HOME = C:\eclipse
##
PATH = %ECLIPSE_HOME%,...
##
CATALINA_HOME = C:\tomcat
##
PATH = %CATALINA_HOME%,..
##
[Obs: Não se esqueça de colocar os caminhos de acordo com sua instalação.]

##
##

### Configurando o TomCat na IDE.
	Vá em Windows> Preferences> Server> Runtime Everonments> Add
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/tomcat%20configuracao%2001.PNG?raw=true)
##
##
	Selecione TomCat 8 e marque a opção para criar em um novo local
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/tomcat%20configuracao%2002.PNG?raw=true)	
##
##
	Na opção JRE selecione a instalação JDK do java
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/tomcat%20configuracao%2003.PNG?raw=true)	
##
##
	Se tudo ocorrer bem o tomcat estará adicionado, mas a diante, veremos como subir 
	o projeto depois pronto.
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/tomcat%20configuracao%2004.PNG?raw=true)	
  
  
##
##
##
##



# *Iniciando o Projeto
    Vamos Criar um novo projeto "Dynamic Web project" (Poderia ser um projeto maven), 
    mas não vamos complicar agora é mais pra entender o conceito.
    
##
##
##

![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/new%20project%2001.png?raw=true)
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/new%20project%2002.png?raw=true)
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/new%20project%2003.png?raw=true)

##
##
##
# *A estrutura do projeto deve ficar parecida com essa:
##
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/EstruturaProjeto.PNG?raw=true)

##
##
##
##

# Adicionando as libs de dependência
    Para resumir as dependências vamos usar:
##
    Hibernate e suas dependências para o mapeamento na nossa base de dados
##
    Javax.faces, Java Server Faces (JSF) é uma especificação Java para a 
    construção de interfaces de usuário baseadas em componentes para aplicações web.
##
    primefaces, PrimeFaces é uma biblioteca de componentes de código aberto para 
    o JSF 2.0 para criar as interfaces Web.
##
    mysql-connector, vamos usar para conectar na nossa base mysql
    
    Baixe esse arquivo, descompacte arraste para a pasta lib no projeto
https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/lib/libs-dependencies.rar
##
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/libs%20descompactadas.PNG?raw=true)
##
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/pasta%20correta%20libs.PNG?raw=true)
##
##
##


# *Criando as classes
    Vamos trabalhar com a estrutura MVC "Model, View, Controller", onde nossa classe
    "Modelo" representará nossa tabela, nosso Controller que chamaremos de "DAO" fará 
    a persistência de dados e por fim nossa "View" que representaremos como classeMB 
    "ManagedBean" que comunicara com nosso frontEnd Através do framework "JSF".
    
    
##
# Modelo  
    Criaremos uma classe Pessoa dentro de um package "Model" com os atributos
    "codigo, nome, telefone, email";
##    
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/new%20classe%20Pessoa.PNG?raw=true)

# Classe Pessoa
```java

    package model;

    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    
    @Entity
    public class Pessoa {
    	
    	@Id
    	@GeneratedValue(strategy=GenerationType.IDENTITY)
    	private int id;
    	
    	@Column 
    	private String nome;
    	
    	@Column 
    	private String email;
    	
    	@Column 
    	private String telefone;	
    	
    	
    
    }
}
```

# Vamos gerar os Getters And Setters para publicar nossos atributos

![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/model-generated-gettersandsetters.png?raw=true)

    
# Classe pessoa completa
```java
    package model;

    import javax.persistence.Column;
    import javax.persistence.Entity;    
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;

    @Entity
    public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column 
	private String nome;
	
	@Column 
	private String email;
	
	@Column 
	private String telefone;
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
    }
```

# Agora vamos configurar nosso arquivo de persistência para conexão com o MYSQL.
##
##
	Crie um novo folder chamado META-INF dentro da pasta "src"
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/new%20Folder.PNG?raw=true)
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/new%20Folder%20META-INF.PNG?raw=true)

##
##
	Crie um novo arquivo com o nome persistence.xml dentro da pasta META-INF que acabou de criar
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/new%20file%20persistence.PNG?raw=true)



##
##
# Copie o conteudo e cole no corpo do arquivo
```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<persistence version="1.0"
		xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd">
	    <persistence-unit name="conexao" transaction-type="RESOURCE_LOCAL">  
	    	<provider>org.hibernate.ejb.HibernatePersistence</provider>  
	    	
	    	<class>model.Contato</class>
	    	
	        <properties>
	       		<property name="hibernate.archive.autodetection" value="class" />
	       		 
	            <!-- Conexão com o banco de dados -->
				<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5InnoDBDialect" />
				<property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver" />						
				<property name="hibernate.connection.url" 	value="jdbc:mysql://LocalHost:3306/java-jsf-primefaces-basico" />
				<property name="hibernate.connection.user" value="root" />
				<property name="hibernate.connection.password" value="root" />
	            <property name="hibernate.hbm2ddl.auto" value="create" />
	            <property name="hibernate.hbm2ddl.auto" value="update"/>
	 
	            <!--Configuracoes de Debug-->
				<property name="hibernate.show_sql" value="true" />
				<property name="hibernate.format_sql" value="true" />
				<property name="use_sql_comments" value="true" />
				
			</properties>
	    </persistence-unit>
	</persistence>
```


# Entendendo o Arquivo

	Temos a linha <class>model.Pessoa</class>, onde mapeamos quem são nossas 
	classes entidades, ou seja, todas as classes modelos que representam as 
	tabelas do banco de dados precisam ser mapeadas aqui.
	Na linha "hibernate.connection.url" temos o caminho do MYSQL junto com seu schema 
	( Não esqueça de criar o schema "java-jsf-primefaces-basico" no MYSQL).
	Usuário e Senha padrão do MYSQL root root, altere caso seu MYSQL seja outro usuário e senha.
	já nas linhas <property name="hibernate.hbm2ddl.auto" value="create" /> e 
	<property name="hibernate.hbm2ddl.auto" value="update" />. significa 
	que o hibernate irá criar as tabelas e atributos na base de dados e alterar se necessário
	
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/configure%20persistence.PNG?raw=true)


##
##
##
##

# Vamos criar nosso DAO
##
##
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/NewPessoaDAO.PNG?raw=true)
##
	Note que se Colocar um package que não existe a própria IDE irá criá-lo.

# Estrutura de Pastas após criar o DAO deve ficar assim:
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/NewPessoaDAOEstrutura.PNG?raw=true)
	
	
# Crud Básico
	Para o DAO, vamos fazer nosso CRUD básico com os métodos de Salvar, Excluir e 
	Listar usando a API de persistência JPA.
	-----------------------------------------------------------------------------------
```java	
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Pessoa;

public class PessoaDAO {
	EntityManagerFactory emf;
	EntityManager em;

	public PessoaDAO() {
		emf = Persistence.createEntityManagerFactory("conexao");
		em = emf.createEntityManager();

	}

	public void salvar(Pessoa pessoa) {
		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();
		emf.close();

	}

	public void excluir(Pessoa pessoa) {
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
		emf.close();
	}
	@SuppressWarnings("unchecked")
	public List<Pessoa> listarTodos() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select pessoa from Pessoa pessoa");
		List<Pessoa> pessoas = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return pessoas;
	}

}
```	
	------------------------------------------------------------------------------------------
##
##
# Confira os imports para certificar que estão buscando do Javax.Persistence
#![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/Imports%20Javax.Persiscente.PNG?raw=true)

##
##
##
# Controller 
	Vamos criar nosso Controller, a classe "Managed Bean" onde nosso FrontEnd vai se comunicar.
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/PessoaMB%20new.PNG?raw=true)
##
	A estrutura ficará assim.
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/PessoaMB%20estrutura.PNG?raw=true)	
##
	A classe contem a anotação @ManagedBean, onde o JSF irá 
	enchergar sua classe e métodos. Eis a mágica, é nessa parte 
	que publicamos o que nosso FrontEnd vai usar. Publicamos aqui 
	nossa classe pessoa, nossa lista de pessoas, e o métodos salvar por enquanto.
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/PessoaMB%20classe.PNG?raw=true)	

##
##
##

# Teste
	Vamos agora testar nossa classe para certificar que está tudo certo, persistindo e listando 
	da base de dados. Primeiro vamos criar o schema no mysql. Instale o MySQL 
	e o Gerenciador Workbench de acordo com a referencia no inicio desse artigo para criar o schema se tiver
	dúvida tem a referencia abaixo.
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/mysql%20Criacao%20de%20Schema.PNG)	
##	
	Agora vamos criar um novo Teste automatizado .
	File>New>Other>Junit Test Case
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/teste%20New.PNG?raw=true)
##
	Se aparecer uma tela pedindo para adicionar a biblioteca do JUNIT pode confirmar
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/teste%20New3.PNG?raw=true)	
##
	Estrutura deve ficar assim:
##
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/teste%20Estrutura.PNG?raw=true)
	
##
##
	Classe Teste
```java
	package test;

	import static org.junit.Assert.*;
	import org.junit.Test;
	
	import dao.PessoaDAO;
	import model.Pessoa;
	
	public class TestePessoa {
		private PessoaDAO pessoaDAO;
		private Pessoa pessoa;
	
		@Test	
		public void testSalvar() {
			pessoa = new Pessoa();
					
			pessoa.setId(1);
			pessoa.setNome("Teste Inserção Pessoa");
			pessoa.setEmail("pessoa@teste.com");
			pessoa.setTelefone("4599991231");
			
			pessoaDAO = new PessoaDAO();
			pessoaDAO.salvar(pessoa);
			
			
			assertTrue(pessoaDAO.listarTodos().size()>0);
					
			
			
		}
	
	}

```


##
	Para executar nosso teste > Botão direito no projeto>Run As>JUnit Test
	Se Tudo ocorrer bem nosso teste deve passar
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/teste%20Run.PNG?raw=true)
##
##
	Se o teste passou então confira na sua base de dados se criou as tabelas e inseriu o registro na tabela Pessoa
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/teste%20MySql.PNG?raw=true)
##
##
# Parte WEB JFS-PRIMEFACES.
	Vamos modificar o web.xml adicionando as dependências do JSF
	
```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
	  <display-name>java-jsf-primefaces-basico</display-name>
	  <welcome-file-list>
	    <welcome-file>index.xhtml</welcome-file>    
	  </welcome-file-list>
	  <servlet>
	    <servlet-name>Faces Servlet</servlet-name>
	    <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
	    <load-on-startup>1</load-on-startup>
	  </servlet>
	  <servlet-mapping>
	    <servlet-name>Faces Servlet</servlet-name>
	    <url-pattern>*.xhtml</url-pattern>
	  </servlet-mapping>
	</web-app>	
```
	
##
##
### Entendendo o Arquivo
	Colocamos a dependência do javax.faces e modificamos a extensão do arquivo html 
	para xhtml que tem mais vantagens e compatibilidades com xml. Mais sobre o assunto 
	no link http://www.maujor.com/w3ctuto/xhtmlfaq.html#need. Mapeamos também quem 
	vai ser o index da pagina, para que ela se direcione para o html padrão quando
	o usuário digitar o link sem referenciar o mesmo.
	
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/webxml%20explicacao.PNG?raw=true)	
##
##
### Pagina HTML
	Vamos lá, o próximo passo é criarmos nossa pagina html com as configurações necessárias 
	para usar o jsf e o primefaces. Em cima da pasta WebContent > New> File. Nomeie como index.xtml.
	Todos os arquivos html ou xhtml devem ficar nessa pasta, porém, pode-se organizar em subpastas.
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/index%20html%20new.PNG?raw=true)	

##
##
### Dependências do arquivo

```html
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"   
	   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
	<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:p="http://primefaces.org/ui">
	<f:view contentType="text/html"></f:view>
	
	
	
	
	
	
	
	
	</html>
	
```
##
### Entendendo o arquivo
	As dependências do jsf e primefaces estão no topo do arquivo, onde referencia a 
	letra p para primefaces e as demais para jsf.

![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/index%20html%20dependencias.PNG?raw=true)	
		
##
##
### 	A partir dai, é só colocar os componentes primefaces e ligar com o ManagedBean e seus métodos.

	Vamos começar com inputs e um botão para salvar. Para exemplos temos o site do 
	primefaces que tem os componentes prontos http://www.primefaces.org/showcase/ .
	Para exemplificar o xhtml, temos os componentes do primefaces dentro de um 
	panelGrid para que quando salvarmos alguma informação, a propriedade update possa
	atualizar os componentes e assim termos um refresh desses campos que foram 
	criados dentro do panel. Repare que para cada input(autoComplete) tem um 
	outPut label para descrição referenciando para o id do input, assim a 
	descrição fica alinhada ao componente. Já no splitButton setamos a propriedade 
	update, para fazer o refresh da pagina. Mais abaixo temos um dataTable para 
	listar as informações da buscando do controller uma Lista. Também tem os 
	atributos ligados a um outputText do dataTable;
	
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/index%20html%20Explicacao.PNG?raw=true)	

##
# Index Completo

```xhtml
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"   
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:p="http://primefaces.org/ui">
<f:view contentType="text/html"></f:view>

<h:head>

</h:head>


<h:body>
	<h:form>
	
	<!-- Form de Cadastro -->
		<h:panelGrid id="panelgrid" columns="2" cellpadding="5">
			<p:outputLabel value="Nome:" for="acNome" />
			<p:autoComplete id="acNome" value="#{pessoaMB.pessoa.nome}" />
			<p:outputLabel value="E-Mail:" for="acEmail" />
			<p:autoComplete id="acEmail" value="#{pessoaMB.pessoa.email}" />
			<p:outputLabel value="Telefone:" for="acTelefone" />
			<p:autoComplete id="acTelefone" value="#{pessoaMB.pessoa.telefone}" />
 			<p:growl id="messages" /> 
			<p:splitButton value="salvar" action="#{pessoaMB.salvar}"
				type="button" update="panelgrid" icon="ui-icon-disk">
			</p:splitButton>


			<!-- Grid de Consulta -->
			<p:dataTable var="c" value="#{pessoaMB.list}">
				<p:column headerText="Id">
					<h:outputText value="#{c.id}" />
				</p:column>
				<p:column headerText="Nome">
					<h:outputText value="#{c.nome}" />
				</p:column>
				<p:column headerText="Email">
					<h:outputText value="#{c.email}" />
				</p:column>
				<p:column headerText="Telefone">
					<h:outputText value="#{c.telefone}" />
				</p:column>
			</p:dataTable>
		</h:panelGrid>
	</h:form>
	
</h:body>


</html>
```


##
##
# Testando a aplicação
	Botão direito no projeto> Run Server. Como não tem ainda um servidor 
	configurado para o projeto, vamos definir o tomcat instalado no inicio do tutorial.
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/iniciando%20server%2001.PNG?raw=true)	
##
	Confira se o projeto está selecionado e finish
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/iniciando%20server%2002.PNG?raw=true)	


# Por fim a nossa pagina rodando no navegador.
![](https://github.com/adrianoarantesms/java-jsf-primefaces-basico/blob/master/slides/pagina%20Start.PNG?raw=true)


### Resumindo era isso que queria mostrar, para quem está aprendendo é importante ter uma visao geral como funciona os dois mundos, e deixo como desafio implementar os métodos alterar e excluir. Até a próxima.
