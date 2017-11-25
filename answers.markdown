
<h3>Are the resulting word frequencies any different?</h3><br>
No, they are no different. If they were different, it would be due to inefficient implementation of myHashmap

<h3>Is the time performance any different? If so, how would you rank the three implementations (in increasing order of time complexity)?</h3><br>
 1. HashMap <br> 
 2. MyHashMap <br> 
 3. TreeMap  <br> 

<h1>How are % and Math.floorMod different? Which works more reliably for computing a hash table index?</h1><br>

math.floormod would work better for our purposes, because it knows how to handle and will never return negative numbers. Modulo alone will not do this, it cannot effectively handle negative numbers. 

<h1>What is the time complexity of MyHashMap.size(), and how could you make it much more efficient?</h1><br>
It is O(n). 
<h1>How does this implementation compare to one where you would directly use your linked Node class from the earlier assignment? Answer briefly in terms of ease of implementation, correctness, reliability, and performance.</h1><br>
In terms of all aforementioned terms, they seem to be fairly equivalent. MyHashMap is somewhat more reliable, but there is not any major difference. 