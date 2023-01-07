package com.rajeshkawali.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * @author Rajesh_Kawali
 */
public class CollectorsExample {
	/*
	Collectors class is a utility class in Java that provides factory methods for 
	creating instances of the Collector interface. A Collector is a special kind of Reducer 
	that accumulates elements into a mutable result container, such as a List or Map, 
	and can perform an additional reduction step on the result.

	The Collectors class provides many static factory methods for creating Collector instances, 
	which can be used in conjunction with the collect method of the Stream interface to perform 
	operations like grouping, partitioning, and summarizing elements in a stream.
	*/
	public static void main(String[] args) {
		List<String> names = List.of("Laksh", "Keshav", "Mahesh", "Kiran", "Rajesh", "Sonu");

		Map<Integer, List<String>> namesByLength = names.stream().collect(Collectors.groupingBy(String::length));

		System.out.println(namesByLength); // {4=[Sonu], 5=[Laksh, Kiran], 6=[Keshav, Mahesh, Rajesh]}
	}
}

/*
List of the most commonly used methods of the Collectors class in Java:-->

toList() - Collects elements in a stream and returns them as a List.
toSet() - Collects elements in a stream and returns them as a Set.
toCollection(Supplier<C> collectionFactory) - Collects elements in a stream and returns them as a collection of the specified type. The collection is created using the provided collectionFactory function.
toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper) - Collects elements in a stream and returns them as a Map, with the keys and values being computed using the provided keyMapper and valueMapper functions.
groupingBy(Function<? super T,? extends K> classifier) - Groups elements in a stream by a certain criteria and returns a Map where the keys are the group names and the values are the elements that belong to that group.
summingInt(ToIntFunction<? super T> mapper) - Collects elements in a stream and returns the sum of their values, as computed by the provided mapper function.
averagingInt(ToIntFunction<? super T> mapper) - Collects elements in a stream and returns the average of their values, as computed by the provided mapper function.
joining() - Collects elements in a stream and returns them as a single String, with the elements being separated by a default separator (a comma followed by a space).
joining(CharSequence delimiter) - Collects elements in a stream and returns them as a single String, with the elements being separated by the specified delimiter.
counting() - Collects elements in a stream and returns a Long representing the number of elements in the stream.
minBy(Comparator<? super T> comparator) - Collects elements in a stream and returns an Optional containing the minimum element, as determined by the provided comparator.
maxBy(Comparator<? super T> comparator) - Collects elements in a stream and returns an Optional containing the maximum element, as determined by the provided comparator.
partitioningBy(Predicate<? super T> predicate) - Collects elements in a stream and returns a Map where the keys are true and false, and the values are the elements that match the predicate and those that don't, respectively.
summarizingInt(ToIntFunction<? super T> mapper) - Collects elements in a stream and returns a IntSummaryStatistics object containing various summary statistics about the elements, such as the count, sum, minimum, maximum, and average.
summarizingLong(ToLongFunction<? super T> mapper) - Collects elements in a stream and returns a LongSummaryStatistics object containing various summary statistics about the elements, such as the count, sum, minimum, maximum, and average.
summarizingDouble(ToDoubleFunction<? super T> mapper) - Collects elements in a stream and returns a DoubleSummaryStatistics object containing various summary statistics about the elements, such as the count, sum, minimum, maximum, and average.
reducing(T identity, BinaryOperator<T> accumulator) - Collects elements in a stream and reduces them to a single value using a provided accumulator function. An initial identity value is used to seed the reduction.
reducing(BinaryOperator<T> accumulator) - Collects elements in a stream and reduces them to a single value using a provided accumulator function. The reduction starts with the first element in the stream and does not use an initial identity value.
reducing(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner) - Collects elements in a stream and reduces them to a single value using a provided accumulator function. An initial identity value and a combiner function are used to seed and combine the reduction.
collectingAndThen(Collector<T,A,R> downstream, Function<R,RR> finisher) - Collects elements in a stream using the provided downstream collector, and then applies a final transformation to the result using the provided finisher function.
teeing(Collector<? super T,A,R> collector1, Collector<? super T,A,R> collector2, BiFunction<R,R,RR> merger) - Collects elements in a stream using two provided collectors, and then combines their results using the provided merger function.
mapping(Function<? super T,? extends U> mapper, Collector<? super U,A,R> downstream) - Collects elements in a stream, applies a mapping function to each element, and then collects the resulting values using the provided downstream collector.
filtering(Predicate<? super T> predicate, Collector<? super T,A,R> downstream) - Collects elements in a stream, filters out elements that do not match the provided predicate, and then collects the remaining elements using the provided downstream collector.
flatMapping(Function<? super T,? extends Stream<? extends U>> mapper, Collector<? super U,A,R> downstream) - Collects elements in a stream, applies a mapping function to each element that returns a stream of values, and then flattens the resulting streams into a single stream before collecting the values using the provided downstream collector.
toConcurrentMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper) - Collects elements in a stream and returns them as a ConcurrentMap, with the keys and values being computed using the provided keyMapper and valueMapper functions.
toConcurrentMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction) - Collects elements in a stream and returns them as a ConcurrentMap, with the keys and values being computed using the provided keyMapper and valueMapper functions. If two elements map to the same key, the mergeFunction is used to merge their values.
toConcurrentMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction, Supplier<M> mapFactory) - Collects elements in a stream and returns them as a ConcurrentMap, with the keys and values being computed using the provided keyMapper and valueMapper functions. If two elements map to the same key, the mergeFunction is used to merge their values. The mapFactory function is used to create the ConcurrentMap.
toUnmodifiableList() - Collects elements in a stream and returns them as an unmodifiable List.
toUnmodifiableSet() - Collects elements in a stream and returns them as an unmodifiable Set.
toUnmodifiableMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper) - Collects elements in a stream and returns them as an unmodifiable Map, with the keys and values being computed using the provided keyMapper and valueMapper functions.
toUnmodifiableMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction) - Collects elements in a stream and returns them as an unmodifiable Map, with the keys and values being computed using the provided keyMapper and valueMapper functions. If two elements map to the same key, the mergeFunction is used to merge their values.
groupingBy(Classifier<? super T> classifier) - Collects elements in a stream and returns a Map whose keys are the values computed by the provided classifier function, and whose values are Lists containing the elements that map to those keys.
groupingBy(Classifier<? super T> classifier, Collector<? super T,A,D> downstream) - Collects elements in a stream and returns a Map whose keys are the values computed by the provided classifier function, and whose values are the results of collecting the elements that map to those keys using the provided downstream collector.
groupingBy(Function<? super T,? extends K> classifier) - Collects elements in a stream and returns a Map whose keys are the values computed by the provided classifier function, and whose values are Lists containing the elements that map to those keys.
groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream) - Collects elements in a stream and returns a Map whose keys are the values computed by the provided classifier function, and whose values are the results of collecting the elements that map to those keys using the provided downstream collector.
groupingBy(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream) - Collects elements in a stream and returns a Map whose keys are the values computed by the provided classifier function, and whose values are the results of collecting the elements that map to those keys using the provided downstream collector. The mapFactory function is used to create the Map.
groupingByConcurrent(Function<? super T,? extends K> classifier) - Collects elements in a stream and returns a concurrent Map whose keys are the values computed by the provided classifier function, and whose values are Lists containing the elements that map to those keys.
groupingByConcurrent(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream) - Collects elements in a stream and returns a concurrent Map whose keys are the values computed by the provided classifier function, and whose values are the results of collecting the elements that map to those keys using the provided downstream collector.
groupingByConcurrent(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream) - Collects elements in a stream and returns a concurrent Map whose keys are the values computed by the provided classifier function, and whose values are the results of collecting the elements that map to those keys using the provided downstream collector. The mapFactory function is used to create the Map.
partitioningBy(Predicate<? super T> predicate) - Collects elements in a stream and returns a Map with two keys: true and false. The elements in the stream are partitioned into the true and false keys based on whether they match the provided predicate. The values for the two keys are Lists containing the elements that map to those keys.
partitioningBy(Predicate<? super T> predicate, Collector<? super T,A,D> downstream) - Collects elements in a stream and returns a Map with two keys: true and false. The elements in the stream are partitioned into the true and false keys based on whether they match the provided predicate. The values for the two keys are the results of collecting the elements that map to those keys using the provided downstream collector.

*/