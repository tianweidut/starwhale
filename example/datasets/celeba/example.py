import io

from PIL import Image as PILImage
from PIL import ImageDraw

from starwhale import dataset

ds_name = "celeba-align/version/latest"
ds = dataset(ds_name)
row = ds["000019.jpg"]
data = row.data
annotations = row.annotations
print(annotations)
with PILImage.open(io.BytesIO(data.fp)) as img:
    draw = ImageDraw.Draw(img)
    draw.point(annotations["landmark"]["left_eye"].to_list(), fill="green")
    draw.point(annotations["landmark"]["right_eye"].to_list(), fill="green")
    draw.point(annotations["landmark"]["left_mouse"].to_list(), fill="green")
    draw.point(annotations["landmark"]["right_mouse"].to_list(), fill="green")
    draw.point(annotations["landmark"]["nose"].to_list(), fill="green")
    img.show()