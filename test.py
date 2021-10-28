import torch
import numpy as np

data = [[1, 2, 3, 4, 5],
[1, 2, 3, 4, 5],
[1, 2, 3, 4, 5],
[1, 2, 3, 4, 5],
[1, 2, 3, 4, 5],
        ]
x_data = torch.tensor(data)
np_array = np.array(data)
x_np = torch.from_numpy(np_array)


# x_ones = torch.ones_like(x_data) # retains the properties of x_data
# print(f"Ones Tensor: \n {x_ones} \n")
#
# x_rand = torch.rand_like(x_data, dtype=torch.float) # overrides the datatype of x_data
# print(f"Random Tensor: \n {x_rand} \n")

# tensor = torch.rand(3,4)
#
# print(f"Shape of tensor: {tensor.shape}")
# print(f"Datatype of tensor: {tensor.dtype}")
# print(f"Device tensor is stored on: {tensor.device}")


print(x_data)
tensor = x_data
# 逐个元素相乘结果
# print(f"tensor.mul(tensor): \n {tensor.matmul(tensor.T)} \n")
# 等价写法:
# print(f"tensor * tensor: \n {tensor * tensor}")
tensor.t_()
print(tensor)

