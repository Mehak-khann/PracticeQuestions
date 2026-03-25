class Twitter {
   HashMap<Integer,HashSet<Integer>>followMap;
   HashMap<Integer,List<int[]>>userTweet;
   int time;
    public Twitter() {
      followMap=new HashMap<>();
      userTweet=new HashMap<>();
      time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
       if(!userTweet.containsKey(userId)){
        userTweet.put(userId,new ArrayList<>());
       } 
       userTweet.get(userId).add(new int[]{tweetId,time++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]>minHeap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        Set<Integer>follow=followMap.getOrDefault(userId,new HashSet<>());
        follow.add(userId);

        for(int followeeId:follow){
            List<int[]>tweets=userTweet.getOrDefault(followeeId,new ArrayList<>());
            for(int [] tweet:tweets){
                minHeap.add(tweet);
                if(minHeap.size()>10){
                    minHeap.poll();
                }
            }
        }
        List<Integer>res=new LinkedList<>();
        while(!minHeap.isEmpty()){
            res.add(0,minHeap.poll()[0]);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            followMap.put(followerId,new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId!=followeeId && followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */