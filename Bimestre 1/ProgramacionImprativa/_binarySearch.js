function binarySearch(list, item){
    // set lowest point
    let low = 0;
    // set highest point
    let high = list.length - 1;
    // while low is less than or equal to high
    while (low <= high){
        // Find the midpoint size of the array
        const mid = Math.floor((low + high) / 2);
        // Guess the mid value is the one we are looking for
        const guess = list[mid];
        if (guess === item){
            return mid;
        }
        // Is item greater or less than guess
        if (guess > item){
            // Modify high point
            high = mid - 1;
        }
        else{
            // Modify low point
            low = mid + 1;
        }
    }
    // If the item is not found
    return null;
}