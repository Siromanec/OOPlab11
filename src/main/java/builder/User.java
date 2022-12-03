package builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Builder
@ToString
public class User
{
    private  int id;
    private  String firstName;
    private  String lastName;
    private  String email;
    private LocalDate dob;
    private double weight;
    private double height;
    @Singular(value = "occupation")
    private List<String> occupations;

    public static void main(String[] args) {
        User  user = User.builder().firstName("serhii").lastName("ivanov").occupation("student").dob(LocalDate.parse(("2003-10-17"))).build();
        System.out.println(user);
    }


}
