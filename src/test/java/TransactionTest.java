import com.mftplus.jee03practice.model.entity.Transaction;
import com.mftplus.jee03practice.model.service.TransactionService;

import java.time.LocalDate;


public class TransactionTest {
    public static void main(String[] args) throws Exception {
            Transaction transaction = Transaction.builder()
                    .transactionNumber(32L)
                    .transactionDate(LocalDate.of(2021, 3, 1))
                    .build();
        TransactionService.save(transaction);
            System.out.println("success Saved" + transaction);
    }
}
