def solve_fry_game(fries):
    n = len(fries)
    if n == 0:
        return 0
    
    G = [1] * n   
    D = [1] * n
    
    for i in range(n-2, -1, -1):
        for j in range(i+1, n):
            if fries[j] < fries[i]:  
                G[i] = max(G[i], 1 + G[j])
    
    for i in range(n-2, -1, -1):
        for j in range(i+1, n):
            if fries[j] > fries[i]: 
                D[i] = max(D[i], 1 + D[j])
    
    max_length = 0
    
    for i in range(n):
        max_length = max(max_length, G[i])
        max_length = max(max_length, D[i])
    
    for i in range(n):
        best_left = 0
        best_right = 0
        
        for j in range(i+1, n):
            if fries[j] < fries[i]:
                best_left = max(best_left, G[j])
            if fries[j] > fries[i]:
                best_right = max(best_right, D[j])
        
        max_length = max(max_length, 1 + best_left + best_right)
    
    return max_length