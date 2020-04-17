import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSearchAlgorithmsInvoke
{
    public class MaxSearchAlgorithms
    {
        public List<Integer> LeftScan(List<Integer> list)
        {
            ArrayList<Integer> maxVal = new ArrayList<>();
            maxVal.add(list.get(0));
            for(int i = 1; i < list.size(); ++i)
            {
                if(list.get(i) > maxVal.get(maxVal.size()-1)){
                    maxVal.add(list.get(i));
                }
            }
            return maxVal;
        }

        public List<Integer> RightScan(List<Integer> list)
        {
            ArrayList<Integer> maxVal = new ArrayList<>();

            for(int i = list.size()-1; i > 0; --i)
            {
                if(maxVal.isEmpty()) {
                    maxVal.add(list.get(i));
                }
                else if(list.get(i) > maxVal.get(maxVal.size()-1)){
                    maxVal.add(list.get(i));
                }
            }
            return maxVal;
        }

        public List<Integer> OddEvenScan(List<Integer> list)
        {
            ArrayList<Integer> maxVal = new ArrayList<>();
            for(int i = 0; i < list.size(); ++i)
            {
                if(i%2 == 0)
                    if(maxVal.isEmpty())
                        maxVal.add(list.get(i));
                    else if (list.get(i) > maxVal.get(maxVal.size() - 1)){
                        maxVal.add(list.get(i));
                    }
            }

            for(int i = 0; i < list.size(); ++i)
            {
                if(i%2 != 0)
                    if(maxVal.isEmpty()){
                        maxVal.add(list.get(i));
                    }
                    else if(list.get(i) > maxVal.get(maxVal.size()-1)){
                        maxVal.add(list.get(i));
                    }
            }
            return maxVal;
        }

        public List<Integer> DummyClass(List<Integer> list){
            System.out.println("Dummy Class");
            return list;
        }

        public List<Integer> DummyClass2(List<Integer> list){
            System.out.println("Dummy Class 2");
            return list;
        }
    }

    public void selectMethods(List<Integer> list) {
        MaxSearchAlgorithms maxSearchAlgorithms = new MaxSearchAlgorithms();
        List<Method> filterMethods = Arrays.asList(maxSearchAlgorithms.getClass().getDeclaredMethods()).stream().
                filter(method -> method.getName().toLowerCase().contains("scan")).collect(Collectors.toList());

        for (Method m : filterMethods) {
            List<Integer> listTemp = null;
            try {
                listTemp = (List<Integer>) m.invoke(maxSearchAlgorithms, list);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                for (Integer i : listTemp) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }
}