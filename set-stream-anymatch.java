import java.util.List;
import java.util.Set;
import java.util.HashSet;
class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        Set<String> newCollection = new HashSet<>(cards);
    
        return newCollection;
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        // Check if there is at least one card in myCollection that is not in theirCollection
        boolean myUnique = myCollection.stream().anyMatch(card -> !theirCollection.contains(card));

        // Check if there is at least one card in theirCollection that is not in myCollection
        boolean theirUnique = theirCollection.stream().anyMatch(card -> !myCollection.contains(card));

        // Trade is possible if both collections have unique cards
        return myUnique && theirUnique;

         // Create copies of the collections
        // Set<String> myUniqueCards = new HashSet<>(myCollection);
        // Set<String> theirUniqueCards = new HashSet<>(theirCollection);

        // Remove common elements from the copies
        // myUniqueCards.removeAll(theirCollection);
        // theirUniqueCards.removeAll(myCollection);

        // Trade is possible if both sets of unique cards are not empty
        // return !myUniqueCards.isEmpty() && !theirUniqueCards.isEmpty();
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        if (collections.isEmpty()) {
            return new HashSet<>();
        }

        Set<String> common = new HashSet<>(collections.get(0));
        for (int i = 1; i < collections.size(); i++) {
            common.retainAll(collections.get(i));
        }

        return common;

        
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> differentsCards = new HashSet<>();
        for (Set<String> collection : collections) {
            differentsCards.addAll(collection);
        }

        return differentsCards;
    }
}
