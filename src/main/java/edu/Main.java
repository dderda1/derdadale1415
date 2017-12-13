package hw;

import java.util.*;
import org.jgrapht.*;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.interfaces.*;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*;

public class Main {
  static final String PL = countrycodes.PL;
  static final String DE = countrycodes.DE;
  static final String CZ = countrycodes.CZ;
  static final String SK = countrycodes.SK;
  static final String UA = countrycodes.UA;
  static final String BY = countrycodes.BY;

  public static void main(final String[] args) {
    final Graph<String, DefaultEdge> map = new SimpleGraph<>(DefaultEdge.class);
    map.addVertex(PL);
    map.addVertex(DE);
    map.addVertex(CZ);
    map.addVertex(SK);
    map.addVertex(UA);
    map.addVertex(BY);
    map.addEdge(PL, DE);
    map.addEdge(PL, CZ);
    map.addEdge(PL, SK);
    map.addEdge(PL, UA);
    map.addEdge(PL, BY);
    map.addEdge(DE, CZ);
    map.addEdge(CZ, SK);
    map.addEdge(SK, UA);
    map.addEdge(UA, BY);
    System.out.println(map);
    final Iterator<String> bf = new BreadthFirstIterator<>(map, PL);
    while (bf.hasNext()) {
      final String country = bf.next();
      System.out.println(" BF search starting with Polska: " + country);
    }
    final Iterator<String> bf1 = new BreadthFirstIterator<>(map, CZ);
    while (bf1.hasNext()) {
      final String country = bf1.next();
      System.out.println(" BF search starting with Czechy: " + country);
    }
    final Iterator<String> cf = new ClosestFirstIterator<>(map, PL);
    while (cf.hasNext()) {
      final String country = cf.next();
      System.out.println(" CF search starting with Polska: " + country);
    }
    final Iterator<String> cf1 = new ClosestFirstIterator<>(map, CZ);
    while (cf1.hasNext()) {
      final String country = cf1.next();
      System.out.println(" CF search starting with Czechy: " + country);
    }
    final Iterator<String> df = new DepthFirstIterator<>(map, PL);
    while (df.hasNext()) {
      final String country = df.next();
      System.out.println(" DF search starting with Polska: " + country);
    }
    final Iterator<String> df1 = new DepthFirstIterator<>(map, CZ);
    while (df1.hasNext()) {
      final String country = df1.next();
      System.out.println(" DF search starting with Czechy: " + country);
    }
    final Iterator<String> rwi = new RandomWalkIterator<>(map, PL, false, 10);
    while (rwi.hasNext()) {
      final String country = rwi.next();
      System.out.println(" RWI search starting with Polska: " + country);
    }
    final Iterator<String> rwi1 = new RandomWalkIterator<>(map, CZ, false, 10);
    while (rwi1.hasNext()) {
      final String country = rwi1.next();
      System.out.println(" RWI search starting with Czechy: " + country);
    }
    GreedyColoring colors = new GreedyColoring(map);
    System.out.println(colors.getColoring());
  }
}
