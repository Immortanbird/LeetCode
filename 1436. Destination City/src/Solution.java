/*
* You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
* It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
* */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> departures = new HashSet<>();

        for (List<String> path : paths)
            departures.add(path.get(0));

        for (List<String> path : paths) {
            if (!departures.contains(path.get(1)))
                return path.get(1);
        }

        return "";
    }
}
