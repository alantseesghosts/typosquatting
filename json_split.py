import json

def split_json_file(input_file, output_prefix, chunk_size):
    with open(input_file, 'rb') as f:
        data = json.load(f)

    # Assuming data is a list, you can split it into chunks of the specified size
    chunks = [data[i:i + chunk_size] for i in range(0, len(data), chunk_size)]

    for i, chunk in enumerate(chunks):
        output_file = f"{output_prefix}_{i}.json"
        with open(output_file, 'w') as out_f:
            json.dump(chunk, out_f, indent=2)

# Usage example
split_json_file('/home/alant/Desktop/packages.json', '/home/alant/Desktop/npm_dir', 1000)
