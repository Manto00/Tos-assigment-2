////////////////////////////////////////////////////////////////////
// [GABRIELE] [MANTOAN] [1216746]
// [RAFFAELE] [OLIVIERO] [1216748]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business.exception;

public class BillException extends Throwable{
    public BillException(String errore){
        System.out.print(errore);
    }
}
