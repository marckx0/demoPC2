import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class Principal {

    public void printNiceTeachers(){
        for (List<Pair<Teacher, Boolean>> teachers : this.allYearsTeachers.values()){
            for (Pair<Teacher, Boolean> pair : teachers){
                if(pair.second()){
                    System.out.println(pair.first().Name());
                }
            }
        }
    }

    final private Map<Integer, List<Pair<Teacher, Boolean>>> allYearsTeachers = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(
                    2020,
                    List.of(
                            new Pair<>( new TeacherTC(1,"Josefina"), true),
                            new Pair<>( new TeacherTC(1,"Edonisio"), true),
                            new Pair<>( new TeacherTC(1,"Edufasio"), false)
                    )
            ),
            new AbstractMap.SimpleImmutableEntry<>(
                    2019,
                    List.of(
                            new Pair<>( new TeacherTC(1,"Eduarda"), false),
                            new Pair<>( new TeacherTC(1,"Abelardo"), true),
                            new Pair<>( new TeacherTC(1,"Francisca"), false)
                    )
            )
    );
    private final int yearToCalculate;

    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }
    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if (!examsStudents.isEmpty()) {
            
            float gradesSum       = 0f;
            int   gradesWeightSum = 0;

            for (Pair<Integer, Float> examGrade : examsStudents) {
                gradesSum += (examGrade.first() * examGrade.second() / 100);
                gradesWeightSum += examGrade.first();
            }
            boolean hasToIncreasePoint = isHasToIncreaseOneExtraPoint();
            if (hasToIncreasePoint){
                //Aqu'i tengo que imprimir el nombre de los alumnos
                System.out.println("Nombre del Estudiante");
            }
            return computeResult(hasReachedMinimumClasses, gradesSum, gradesWeightSum, hasToIncreasePoint);
        } else {
            return 0f;
        }
    }

    private float computeResult(boolean hasReachedMinimumClasses, float gradesSum, int gradesWeightSum, boolean increasePoint) {
        if (gradesWeightSum == 100) {
            if (hasReachedMinimumClasses) {
                if (increasePoint) {
                    return Float.min(10f, gradesSum + 1);
                } else {
                    return gradesSum;
                }
            } else {
                return 0f;
            }
        } else if (gradesWeightSum > 100) {
            return -1f;
        } else {
            return -2f;
        }
    }

    private boolean isHasToIncreaseOneExtraPoint() {
        boolean hasToIncreaseOneExtraPoint = false;

        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (!(yearToCalculate != yearlyTeachers.getKey())) {
                List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<Teacher, Boolean> teacher : teachers) {
                    if (teacher.second() != true) {
                        continue;
                    }
                    hasToIncreaseOneExtraPoint = true;
                }
            } else {
                continue;
            }
        }
        return hasToIncreaseOneExtraPoint;
    }

    public static void main(String[] args) {
        Principal instance = new Principal(2019);
        instance.printNiceTeachers();

    }
}
