import numpy as np
import matplotlib.pyplot as plt
import mpl_toolkits.mplot3d.axes3d as p3
import matplotlib.animation as animation
import json


def update_lines(num, dataLines, lines) :
    for line, data in zip(lines, dataLines) :
        line.set_data(data[0:2, num-1:num])
        line.set_3d_properties(data[2,num-1:num])
    return lines

def read_data(planete):
    with open("data.csv") as file:
        lines = file.readlines()
    lune_lines = filter(lambda l : planete in l, lines)

    x = []
    y = []
    z = []
    for line in lune_lines:
        parts = line.split("sont ")
        coords= parts[2].strip()[1:-1]
        x_, y_, z_ = coords.split(",")
        x.append(float(x_))
        y.append(float(y_))
        z.append(float(z_))
    return x, y, z

fig = plt.figure()
ax = p3.Axes3D(fig)

x, y, z = read_data("lune")
n = len(x)

x2, y2, z2 = read_data("Terre")
n = len(x)

data = [np.array([x,y,z])]
data2 = [np.array([x2,y2,z2])]

lines = [ax.plot(data[0][0,0:1], data[0][1,0:1], data[0][2,0:1], 'o')[0]]
lines2 = [ax.plot(data2[0][0,0:1], data2[0][1,0:1], data2[0][2,0:1], 'o')[0]]

#ax.plot([0],[0],[0], 'o')

xlim = max([abs(u) for u in x])
ylim = max([abs(u) for u in y])


ax.set_xlim3d([-xlim,xlim])
ax.set_xlabel('X')

ax.set_ylim3d([-xlim, xlim])
ax.set_ylabel('Y')

ax.set_zlim3d([min(z)-1, max(z)+1])
ax.set_zlabel('Z')

ax.set_title('3D Test')

# Creating the Animation object
ani2 = animation.FuncAnimation(fig, update_lines, n, fargs=(data2, lines2),  interval=1, blit=False)
plt.show()