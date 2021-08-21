package net.henrik;

public class Main {

    public static void main(String[] args) {

    }

    /*

    public static int buildString2(int a, int b, String s) {
        //GRAPH AUS STRING MACHEN
        List<Character> alphabet = getAlphabet(s);
        List<String> words = getAllWords(s);
        //alle einfachen teilstrings einfügen
        Graph<String, Integer> graph = new Graph<>();
        for (int i = 0; i <= s.length(); i++)
            for (int j = 0; j < i; j++) {
                var substring = s.substring(j, i);
                if (graph.nodeList.stream().noneMatch(stringNode -> stringNode.key.equals(substring)))
                    graph.addNode(s.substring(j, i));
            }
        var duplicates = getDuplicates(s);
        //Alle Duplikate hinzufügen
        duplicates.forEach((s1, integers) -> {
            var t1 = new StringBuilder();
            for (int i = 0; i < integers.size(); i++)
                t1.append(s1);
            if (!graph.containsNode(t1.toString()))
                graph.addNode(t1.toString());
        });
        for (int i = 1; i < s.length(); i++) {
            graph.addEdge(s.substring(0, i), s.substring(0, i + 1), a);
            if (!graph.containsEdge(s.substring(i - 1, i), s.substring(i - 1, i + 1)))
                graph.addEdge(s.substring(i - 1, i), s.substring(i - 1, i + 1), a);
        }

        for (var node : graph.nodeList) {
            if (duplicates.containsKey(node.key)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(node.key);
                for (int i = 1; i < duplicates.get(node.key).size(); i++) {
                    var oldString = stringBuilder.toString();
                    stringBuilder.append(node.key);
                    graph.addEdge(oldString, stringBuilder.toString(), b);
                }

            }
        }
        graph.exportTGF();
        System.out.println(graph);


        return -1;
    }

    private static List<String> getAllWordsNew(String s){
        var lst = new LinkedList<String>();
        for (int removeLetters = 0; removeLetters <= s.length(); removeLetters++) {
            lst.addAll(removeLettersFromString(s,removeLetters));
        }
        return lst;
    }

    private static List<String> removeLettersFromString(String s, int removeLetters) {
        List<String> lst = new LinkedList<>();
        for (int placeInWord = 0; placeInWord < s.length(); placeInWord++) {
            while (true) {
                var substring = s;

            }
        }
        return lst;
    }

    private static List<String> getAllWords(String s) {
        var lst = new LinkedList<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                lst.add(s.substring(i, j));
            }
        }
        return lst;
    }

    private static List<Character> getAlphabet(String s) {
        var lst = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!lst.contains(s.charAt(i)))
                lst.add(s.charAt(i));
        }
        return lst;
    }

    public static HashMap<String, List<Integer>> getDuplicates(String s) {
        HashMap<String, Integer> characterHashMap = new HashMap<>();
        HashMap<String, List<Integer>> finalCharacterHashMap = new HashMap<>();

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                var substring = s.substring(j, i);
                if (i - j > s.length() / 2)
                    continue;
                if (characterHashMap.containsKey(substring)) {
                    List<Integer> lst;
                    if (finalCharacterHashMap.containsKey(substring)) {
                        lst = (finalCharacterHashMap.get(substring));
                    } else {
                        lst = new LinkedList<>();
                        lst.add(characterHashMap.get(substring));
                    }
                    lst.add(j);
                    finalCharacterHashMap.put(substring, lst);
                } else
                    characterHashMap.put(substring, j);
            }
        }
        return (finalCharacterHashMap);
    }


     */
}
