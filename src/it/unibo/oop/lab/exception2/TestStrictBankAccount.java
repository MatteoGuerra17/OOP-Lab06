package it.unibo.oop.lab.exception2;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         */
    	StrictBankAccount MarioRossi = new StrictBankAccount(123, 10_000, 10);
    	StrictBankAccount LuigiBianchi = new StrictBankAccount(246, 10_000, 10);
    	
        /* 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	try {
    		MarioRossi.deposit(234, 5_000);
    		System.out.println("ok!!");
    	} catch (WrongAccountHolderException e) {
    		System.out.println("Wrong Account Holder");
    	}
    	
    	try {
    		LuigiBianchi.deposit(246, 1_000);
    		System.out.println("ok!!");
    	} catch (WrongAccountHolderException e) {
    		System.out.println("Wrong Account Holder");
    	}
    	
    	System.out.println("" + LuigiBianchi.getBalance());
    	
    	try {
    		LuigiBianchi.withdraw(246, 11_000);
    		System.out.println("ok!!");
    	} catch (NotEnoughFoundsException e) {
    		System.out.println("Not Enough Founds");
    	}
    }
}
