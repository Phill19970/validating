package grid.capstone.mapper;

import grid.capstone.dto.v1.ExpenseDTO;
import grid.capstone.service.expense_service.domain.Expense;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T05:25:13-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class ExpenseMapperImpl implements ExpenseMapper {

    @Override
    public Expense toEntity(ExpenseDTO expenseDTO) {
        if ( expenseDTO == null ) {
            return null;
        }

        Expense.ExpenseBuilder expense = Expense.builder();

        expense.name( expenseDTO.getName() );
        expense.category( expenseDTO.getCategory() );
        expense.description( expenseDTO.getDescription() );
        expense.amount( expenseDTO.getAmount() );

        return expense.build();
    }

    @Override
    public ExpenseDTO toDTO(Expense expense) {
        if ( expense == null ) {
            return null;
        }

        ExpenseDTO.ExpenseDTOBuilder expenseDTO = ExpenseDTO.builder();

        expenseDTO.name( expense.getName() );
        expenseDTO.category( expense.getCategory() );
        expenseDTO.description( expense.getDescription() );
        expenseDTO.amount( expense.getAmount() );

        return expenseDTO.build();
    }
}
