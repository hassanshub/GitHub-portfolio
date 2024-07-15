import pygame
import random

pygame.init() #initializing pygame

#the width, height and fps are given to justify the view
width = 900
height = 500
fps = 60

#colors
black = (0, 0, 0)
white = (255, 255, 255)
gray = (128, 128, 128)
red = (255, 0, 0)
yellow = (255, 255, 0)
green = (144, 238, 144)

pygame.display.set_caption('AI PROJECT')
screen = pygame.display.set_mode([width, height])
timer = pygame.time.Clock()
font = pygame.font.Font('freesansbold.ttf', 20)

#all variables
player1 = 225 #this is for x-axis/position
player2 = 225 #this is for y-axis/position
y_change = 0 #to change the players y-coordinate
jump_height = 12
gravity = 0.9
obstacles = [600, 700, 1000, 1600]
enemies = [600, 700, 1000, 1600]
generate_places = True
generate_enemy = True
y_positions = []
game_over = False
# game_start = True
speed = 2.8
score = 0
high_score = 0
stars = []


def draw_player(x_pos , y_pos):
    global y_change
    mouth = pygame.draw.circle(screen, gray, (x_pos + 25, y_pos + 15), 12)
    play = pygame.draw.rect(screen, white, [x_pos, y_pos, 28, 28], 0, 12)
    eye = pygame.draw.circle(screen, black, (x_pos + 24, y_pos + 12), 5)
    jetpack = pygame.draw.rect(screen, red, [x_pos - 20, y_pos, 18, 28], 3, 2)

    if y_change < 0:
        flame1 = pygame.draw.rect(screen, yellow, [x_pos - 20, y_pos + 29, 7, 20], 0, 2)
        flame2 = pygame.draw.rect(screen, yellow, [x_pos - 10, y_pos + 29, 7, 20], 0, 2)

    return play


def draw_enemy(enemies, y_pos, play):
    global game_over
    for i in range(len(enemies)):
        y_coord = y_pos[i]
        mouth = pygame.draw.circle(screen, gray, (enemies[i] + 5, y_coord + 20), 15)
        play = pygame.draw.rect(screen, white, [enemies[i], y_coord, 45, 42], 0, 20)
        eye = pygame.draw.circle(screen, black, (enemies[i] + 10, y_coord + 18), 7)
        if mouth.colliderect(player):
            game_over = True

def draw_obstacles(obst, y_pos, play):
        global game_over
        for i in range(len(obst)):
            y_coord = y_pos[i]
            top_rectangle = pygame.draw.rect(screen, gray, [obst[i], 0, 30, y_coord])
            bottom_rectangle = pygame.draw.rect(screen, gray, [obst[i], y_coord + 250, 30, height - (y_coord + 70)])
            if top_rectangle.colliderect(player) or bottom_rectangle.colliderect(player):
                game_over = True


# def draw_obstacles(x_pos, y_pos):
#     global game_over
#         y_coord = y_pos[i]
#         top_rectangle = pygame.draw.rect(screen, gray, [obst[i], 0, 30, y_coord])
#         bottom_rectangle = pygame.draw.rect(screen, gray, [obst[i], y_coord + 250, 30, height - (y_coord + 70)])
#         if top_rectangle.colliderect(player) or bottom_rectangle.colliderect(player):
#             game_over = True
#
#     mouth = pygame.draw.circle(screen, gray, (x_pos + 25, y_pos + 15), 12)
#     play = pygame.draw.rect(screen, white, [x_pos, y_pos, 28, 28], 0, 12)
#     eye = pygame.draw.circle(screen, black, (x_pos + 24, y_pos + 12), 5)
#     jetpack = pygame.draw.rect(screen, red, [x_pos - 20, y_pos, 18, 28], 3, 2)


def draw_stars(stars):
    global total
    for i in range(total - 1):
        pygame. draw.rect(screen, white, [stars[i][0], stars[i][1], 3, 3], 0, 2)
        stars[i][0] -= .5
        if stars[i][0] < -3:
            stars[i][0] = width + 3
            stars[i][1] = random.randint(0, height)
        return stars

running = True
while running:
    timer.tick(fps)
    screen.fill(black)

    if generate_places: #to change the places of obstacle
        for i in range(len(obstacles)):
            y_positions.append(random.randint(0, 300))

        total = 100
        for i in range(total):
            x_pos = random.randint(10, width)
            y_pos = random.randint(10, height)
            stars.append([x_pos, y_pos])
        generate_places = False

    stars = draw_stars(stars)
    player = draw_player(player1, player2)
    enemy = draw_enemy(enemies, y_positions, player)
    draw_obstacles(obstacles, y_positions, player)
    draw_stars(stars)

    for event in pygame.event.get(): #access to all the clicks/events
        if event.type == pygame.QUIT:
            running = False
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_SPACE and not game_over:
                y_change = -jump_height
            if event.key == pygame.K_SPACE and game_over:
                player2 = 225
                player1 = 225
                y_change = 0
                generate_places = True
                obstacles = [700, 700, 1000, 1300, 1600]
                y_positions = []
                score = 0
                # pygame.mixer.music.play()
                game_over = False

    if player2 + y_change < height - 30:
        player2 += y_change
        y_change += gravity #less height the gravity keeps intact
    else:
        player2 = height - 30

    for i in range(len(obstacles)):
        if not game_over:
            obstacles[i] -= speed
            # enemies[i] -= speed
            if obstacles[i] <-30:
                obstacles.remove(obstacles[i])
                y_positions.remove(y_positions[i])
                obstacles.append(random.uniform(obstacles[-1] + 280, obstacles[-1] + 320))
                y_positions.append(random.randint(0, 300))
                score += 1

    for i in range(len(enemies)):
        if not game_over:
            enemies[i] -= speed
            if enemies[i] < -30:
                 enemies.remove(enemies[i])
                 y_positions.remove(y_positions[i])
                 enemies.append(random.uniform(enemies[-1] + 280, enemies[-1] + 320))
                 y_positions.append(random.randint(0, 300))
                 score += 1

    if score > high_score:
        high_score = score
    if game_over:
        game_over_text = font.render('GAME OVER! Press Space Bar to try again!', True, white)
        screen.blit(game_over_text, (200, 200))


    score_text = font.render('Score: ' + str(score), True, white)
    screen.blit(score_text, (10, 450))
    highScore_text = font.render('High Score: ' + str(high_score), True, white)
    screen.blit(highScore_text, (10, 470))

    pygame.display.flip()
pygame.QUIT