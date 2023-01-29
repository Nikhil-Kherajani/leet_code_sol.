class LFUCache {
   int capacity;
    HashMap<Integer, Node> keyNodeMap = new HashMap<>();
    HashMap<Integer, NodeDLinkedList> freqNodeDLLMap = new HashMap<>();
    int minumumFrequency = 1;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = keyNodeMap.get(key);
        if(node != null){                                                              
            incrementFrequency(node);                                                  
            return node.value;                                                         
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(capacity <= 0) return;
        
        if(keyNodeMap.containsKey(key)){                                                     
            Node node = keyNodeMap.get(key);                                            
            node.value = value;                                                        
            incrementFrequency(node);                                                
            keyNodeMap.put(key, node);                                                 
        }
        else{                                                                        
            
            Node node = new Node(key, value);                                    
            
            if(keyNodeMap.size() == capacity){                                          
                Node removedLastNode = freqNodeDLLMap.get(minumumFrequency)
                                        .removeLastNode();                          
                keyNodeMap.remove(removedLastNode.key);                   
            }
            
            incrementFrequency(node);                               
            keyNodeMap.put(key, node);                      
            
            minumumFrequency = 1;                                                      
                                                    
        }
        
    }
    
    
    private void incrementFrequency(Node node){
        
        int oldFrequency = node.frequency;
        
        if(freqNodeDLLMap.containsKey(oldFrequency)){                    
           NodeDLinkedList oldNodeDLinkedList = freqNodeDLLMap.get(oldFrequency);      
            oldNodeDLinkedList.remove(node);           
            if(node.frequency == minumumFrequency &&                                    
                oldNodeDLinkedList.length == 0){                                        
                minumumFrequency++;                                         
            }
        }

        int newFrequency = oldFrequency + 1;                         
        node.frequency = newFrequency;                                     
        NodeDLinkedList newNodeDLinkedList =                                       
            freqNodeDLLMap.getOrDefault(                            
            newFrequency, new NodeDLinkedList()
        );           
        newNodeDLinkedList.add(node);                                            
        freqNodeDLLMap.put(newFrequency, newNodeDLinkedList);                          
    }
    
    
    private class Node{
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }
    
    private class NodeDLinkedList{
        
        Node head, tail;
        int length;
        
        //Add a node to top
        void add(Node node){
            
            //Remove old pointers
            node.prev = null;
            node.next = null;
                
            if(head==null){                                   
                head = node;
                tail = node;
            }
            else{
                node.next = head;                                  
                head.prev = node;                                   
                head = node;
            }
            
            length++;
        }
        
        //Remove a node
        void remove(Node node){
            
            if(node==head){                                                 
                if(node==tail){                                                           
                    tail=null;                                    
                }
                head = head.next;                                                   
            }
            else{                                                            
                node.prev.next = node.next;                        

                if(node==tail){                                             
                    tail = node.prev;                                      
                }
                else{
                    node.next.prev = node.prev;                     
                }
            }
            
            length--;
            
        }
        
        //Remove last node
        Node removeLastNode(){
            
            Node tailNode = tail;
            
            if(tailNode != null){                                   
                remove(tailNode);
            }
            return tailNode;
        }
    }
}