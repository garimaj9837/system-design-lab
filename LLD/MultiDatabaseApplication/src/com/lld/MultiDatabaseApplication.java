package com.lld;

public class MultiDatabaseApplication {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DatabaseFactory factory=new MongoDBFactory();
		DBService service =new DBService(factory);
		service.Connect();
		service.Execute();
		service.createTransaction();
	}
}

//Feature that must provided by all DB
	interface IConnector{
		void Connection();
	}

	interface IQueryExecutor{
		void Execute();
	}
	
	interface TransactionManager{
		void TransactionManager();
	}
	
//Feature implementation as per specific DB
	class PostgresConnector implements IConnector{
		@Override
		public void Connection() {
			System.out.println("Postgres Connection enabled");		
		}
	}
	
	class MongoDBConnector implements IConnector{
		@Override
		public void Connection() {
			System.out.println("Mongo DB Connection enabled");		
		}
	}
	
	class MySqlConnector implements IConnector{
		@Override
		public void Connection() {
			System.out.println("MySql Connection enabled");		
		}
	}
	
	class PostgresQueryExecutor implements IQueryExecutor{
		@Override
		public void Execute() {
			System.out.println("Executing queries using Postgres Connector");		
		}	
	}
	
	class MongoDBExecutor implements IQueryExecutor{
		@Override
		public void Execute() {
			System.out.println("Executing queries using MongoDB Connector");		
		}	
	}
	
	class MySqlExecutor implements IQueryExecutor{
		@Override
		public void Execute() {
			System.out.println("Executing queries using MySql Connector");		
		}	
	}
	
	class PostgresTransactionManager implements TransactionManager{
		@Override
		public void TransactionManager() {
			System.out.println("Postgres Transaction Manager");	
		}	
	}
	
	class MongoDbTransactionManager implements TransactionManager{
		@Override
		public void TransactionManager() {
			System.out.println("Mongo DB Transaction Manager");	
		}	
	}
	
	class MySqlTransactionManager implements TransactionManager{
		@Override
		public void TransactionManager() {
			System.out.println("MySql Transaction Manager");	
		}	
	}
	
//DB Factory to handle all feature creation as per specific DB
	interface DatabaseFactory {

		IConnector createConnection();

		IQueryExecutor createQueryExecutor();

	    TransactionManager createTransactionManager();
	}
	
	class PostgresFactory implements DatabaseFactory{

		@Override
		public IConnector createConnection() {
			return new PostgresConnector();
		}

		@Override
		public IQueryExecutor createQueryExecutor() {
			return new PostgresQueryExecutor();
		}

		@Override
		public TransactionManager createTransactionManager() {
			return new PostgresTransactionManager();
		}
	}
	
	class MongoDBFactory implements DatabaseFactory{

		@Override
		public IConnector createConnection() {
			return new MongoDBConnector();
		}

		@Override
		public IQueryExecutor createQueryExecutor() {
			return new MongoDBExecutor();
		}

		@Override
		public TransactionManager createTransactionManager() {
			return new MongoDbTransactionManager();
		}
		
	}
	
	class MySqlDBFactory implements DatabaseFactory{

		@Override
		public IConnector createConnection() {
			return new MySqlConnector();
		}

		@Override
		public IQueryExecutor createQueryExecutor() {
			return new MySqlExecutor();
		}

		@Override
		public TransactionManager createTransactionManager() {
			return new MySqlTransactionManager();
		}
		
	}
	
//DB service handles function calling
	class DBService{
		IConnector connector;

		IQueryExecutor executor;

	    TransactionManager transactionManager;
		
		DBService(DatabaseFactory factory){
			connector=factory.createConnection();
			executor=factory.createQueryExecutor();
			transactionManager=factory.createTransactionManager();
		}

		public void Connect() {
			connector.Connection();
		}

		public void Execute() {
			executor.Execute();
		}

		public void createTransaction() {
			transactionManager.TransactionManager();
		}
		
	}
	
	


