N = 10000
#test = [str(x) for x in range(N)]
#print('{0} {1}'.format(N, ' '.join(test)))
#print('{0} {1}'.format(N, ' '.join(test)))
largest_n = 1000000000
gap = largest_n/N
test = [str(int(gap)*x) for x in range(N)]
print('{0} {1}'.format(N, ' '.join(test)))
print('{0} {1}'.format(N, ' '.join(test)))
